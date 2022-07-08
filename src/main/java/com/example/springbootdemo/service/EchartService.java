package com.example.springbootdemo.service;

import com.example.springbootdemo.VO.PointVO;
import com.example.springbootdemo.mapper.DataClean1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : liwenlong
 * @Date: 2022/7/8
 */
@Service
public class EchartService {
    @Autowired
    private DataClean1Mapper dataClean1Mapper;

    public List<Integer> getMagSum(){
        List<Integer> list = new ArrayList<>();
        for (int i =1; i <=5; i++){
            list.add(dataClean1Mapper.searchByMagAfter(i,i-1).size());
        }
        return list;
    }

    public List<PointVO> getPoint(){
        return dataClean1Mapper.queryMagAndDepth();
    }
}
