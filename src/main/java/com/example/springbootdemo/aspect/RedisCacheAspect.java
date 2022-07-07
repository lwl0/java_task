package com.example.springbootdemo.aspect;



import com.alibaba.druid.util.FnvHash;
import com.example.springbootdemo.VO.CacheVO;
import com.example.springbootdemo.annotation.RedisCache;
import com.example.springbootdemo.annotation.RedisEvict;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;


/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */

@Aspect
@Component
public class RedisCacheAspect {


//    @Qualifier("redisTemplateForString")
    @Autowired
    StringRedisTemplate rt;


    /**
     * 方法调用前，先查询缓存。如果存在缓存，则返回缓存数据，阻止方法调用;
     * 如果没有缓存，则调用业务方法，然后将结果放到缓存中
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.example.springbootdemo.mapper.DataClean1Mapper.*(..))")
    public Object cache(ProceedingJoinPoint jp) throws Throwable {
        // 得到类名、方法名和参数
        String clazzName = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        // 根据类名，方法名和参数生成key
        String key = genKey(clazzName, methodName, args);


        // 得到被代理的方法
        Method me = ((MethodSignature) jp.getSignature()).getMethod();
        // 得到被代理的方法上的注解
        Class modelType = me.getAnnotation(RedisCache.class).type();

        // 检查redis中是否有缓存
        String value = (String)rt.opsForHash().get(modelType.getName(), key);

        // result是方法的最终返回结果
        Object result = null;
        if (null == value) {


            // 调用数据库查询方法
            result = jp.proceed(args);

            // 序列化查询结果
            String json = serialize(result);

            // 序列化结果放入缓存
            rt.opsForHash().put(modelType.getName(), key, json);
            rt.expire(modelType.getName(), 1800, TimeUnit.SECONDS);

        } else {


            // 得到被代理方法的返回值类型
            Class returnType = ((MethodSignature) jp.getSignature()).getReturnType();

            // 反序列化从缓存中拿到的json
            result = deserialize(value, returnType, modelType);



        }

        return result;
    }

    /**
     * 在方法调用前清除缓存，然后调用业务方法
     * @param jp
     * @return
     * @throws Throwable
     */
//    @Around("execution(* com.example.springbootdemo.mapper.DataClean1Mapper.*(..))")
//    public Object evictCache(ProceedingJoinPoint jp) throws Throwable {
//
//        // 得到被代理的方法
//        Method me = ((MethodSignature) jp.getSignature()).getMethod();
//        // 得到被代理的方法上的注解
//        Class modelType = me.getAnnotation(RedisEvict.class).type();
//
//
//
//        // 清除对应缓存
//        rt.delete(modelType.getName());
//
//        return jp.proceed(jp.getArgs());
//    }



    /**
     * 根据类名、方法名和参数生成key
     * @param clazzName
     * @param methodName
     * @param args 方法参数
     * @return
     */
    protected String genKey(String clazzName, String methodName, Object[] args) {
        StringBuilder sb = new StringBuilder(clazzName);
        sb.append(FnvHash.Constants.DELIMITER);
        sb.append(methodName);
        sb.append(FnvHash.Constants.DELIMITER);

        for (Object obj : args) {
            sb.append(obj.toString());
            sb.append(FnvHash.Constants.DELIMITER);
        }

        return sb.toString();
    }

    protected String serialize(Object target) {
        return JSON.toJSONString(target);
    }

    protected Object deserialize(String jsonString, Class clazz, Class modelType) {
        // 序列化结果应该是List对象
        if (clazz.isAssignableFrom(List.class)) {
            return JSON.parseArray(jsonString, modelType);
        }

        // 序列化结果是普通对象
        return JSON.parseObject(jsonString, clazz);
    }

}

