package com.example.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisEvict {
    Class type();
}

