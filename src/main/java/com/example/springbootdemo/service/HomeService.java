package com.example.springbootdemo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.common.Result;
import com.example.springbootdemo.entity.DataClean1;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.exception.BusinessException;
import com.example.springbootdemo.mapper.DataClean1Mapper;
import com.example.springbootdemo.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */

@Service
public class HomeService {

    @Autowired
    private DataClean1Mapper dataClean1Mapper;

    @Autowired
    private DataMapper dataMapper;

    public void create(DataClean1 dataClean1) throws Exception {
        dataClean1Mapper.insertSelective(dataClean1);
    }

    public void delete(String id) throws Exception{
        dataClean1Mapper.deleteByPrimaryKey(id);
    }

    public Page<DataClean1> search(Integer pageNum, Integer pageSize, String search){

        LambdaQueryWrapper<DataClean1> wrapper = Wrappers.<DataClean1>lambdaQuery();
        if(search != null && !"".equals(search)){
            wrapper.like(DataClean1::getPlace, search);
        }
        Page<DataClean1> userPage = dataMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return userPage;
    }

    public void update(DataClean1 dataClean1){
        dataClean1Mapper.updateByPrimaryKeySelective(dataClean1);
    }

}
