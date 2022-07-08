package com.example.springbootdemo.controller;

import com.example.springbootdemo.common.Result;
import com.example.springbootdemo.service.EchartService;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : liwenlong
 * @Date: 2022/7/8
 */

@CrossOrigin
@RestController
@RequestMapping("/chart")
public class EchartController {

    @Autowired
    private EchartService echartService;

    @GetMapping("/mag")
    public Result getMagSum(){
        try {
            return Result.success(echartService.getMagSum());
        } catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), "数据库随机查询出错");
        }
    }

    @GetMapping("/point")
    public Result getPoint(){
        try {
            return Result.success(echartService.getPoint());
        } catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), "数据库随机查询出错");
        }
    }
}
