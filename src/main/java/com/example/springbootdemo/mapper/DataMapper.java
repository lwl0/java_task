package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.DataClean1;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DataMapper extends BaseMapper<DataClean1> {
}
