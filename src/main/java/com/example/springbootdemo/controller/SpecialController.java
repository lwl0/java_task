package com.example.springbootdemo.controller;

import com.example.springbootdemo.common.Result;
import com.example.springbootdemo.service.SpecialService;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */


@CrossOrigin
@RestController
@RequestMapping("/special")
public class SpecialController {

    @Autowired
    private SpecialService specialService;

    @GetMapping("/rand")
    public Result randSearch(@RequestParam int num){

        try {
            return Result.success(specialService.randSearch(num));
        } catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), "数据库随机查询出错");
        }

    }

    @GetMapping("/condition")
    public Result conditionSearch(@RequestParam String location){

        try {
            return Result.success(specialService.conditionSearch(location));
        } catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), "数据库随机查询出错");
        }

    }
}
