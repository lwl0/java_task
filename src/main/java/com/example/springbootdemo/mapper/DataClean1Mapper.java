package com.example.springbootdemo.mapper;


import com.example.springbootdemo.VO.PointVO;
import com.example.springbootdemo.annotation.RedisCache;
import com.example.springbootdemo.annotation.RedisEvict;
import com.example.springbootdemo.entity.DataClean1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataClean1Mapper extends MyMapper<DataClean1> {

    @RedisCache(type = DataClean1.class)
    List<DataClean1> randSearch(int num);
    @RedisCache(type = DataClean1.class)
    List<DataClean1> conditionQuery(String location);

    List<String> searchByMagAfter(int a,int b);
    List<PointVO> queryMagAndDepth();
}