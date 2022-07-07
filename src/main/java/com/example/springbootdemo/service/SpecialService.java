package com.example.springbootdemo.service;

import com.example.springbootdemo.VO.CacheVO;
import com.example.springbootdemo.VO.SpecialVO;
import com.example.springbootdemo.entity.DataClean1;
import com.example.springbootdemo.mapper.DataClean1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */

@Service
public class SpecialService {

    @Autowired
    private DataClean1Mapper dataClean1Mapper;

    public SpecialVO randSearch(int num) throws NoSuchFieldException {
        long start = System.currentTimeMillis();
        List<DataClean1> dataClean1List = dataClean1Mapper.randSearch(num);
        long end = System.currentTimeMillis();
        SpecialVO specialVO = new SpecialVO();
        specialVO.setData(dataClean1List);
        specialVO.setTime(end-start);
        if ((end-start)< 100){
            specialVO.setCache(true);
        }else {
            specialVO.setCache(false);
        }
        return specialVO;
    }

    public SpecialVO conditionSearch(String location){
        long start = System.currentTimeMillis();
        List<DataClean1> dataClean1List = dataClean1Mapper.conditionQuery(location);
        long end = System.currentTimeMillis();
        SpecialVO specialVO = new SpecialVO();
        specialVO.setData(dataClean1List);
        specialVO.setTime(end-start);
        if ((end-start)< 100){
            specialVO.setCache(true);
        }else {
            specialVO.setCache(false);
        }
        return specialVO;
    }

}
