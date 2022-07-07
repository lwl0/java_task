package com.example.springbootdemo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.springbootdemo.common.Result;
import com.example.springbootdemo.entity.DataClean1;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.exception.BusinessException;
import com.example.springbootdemo.service.HomeService;
import enums.ResultEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */

@CrossOrigin
@RestController    // 表示这是一个控制器
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private HomeService homeService;

    @PostMapping("/create")
    public Result create(@RequestBody DataClean1 dataClean1){

        try {
            homeService.create(dataClean1);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error(ResultEnum.RECORD_CREATE_ERROR.getCode(),ResultEnum.RECORD_CREATE_ERROR.getMessage());
        }
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(String id){

        if (StringUtils.isAllBlank(id)) {
            return Result.error(ResultEnum.PARAM_BLANK.getCode(), ResultEnum.PARAM_BLANK.getMessage());
        }

        try {
            homeService.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error(ResultEnum.RECORD_CREATE_ERROR.getCode(),ResultEnum.RECORD_CREATE_ERROR.getMessage());
        }
        return Result.success();
    }

    @GetMapping("/search")
    public Result search( @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "" ) String search){
        try {
            return Result.success(homeService.search(pageNum, pageSize, search));
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), ResultEnum.DATABASE_ERROR.getMessage());
        }
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody DataClean1 dataClean1) {
        try {
            homeService.update(dataClean1);
            return Result.success();
        } catch (Exception e){
            e.printStackTrace();
            return Result.error(ResultEnum.DATABASE_ERROR.getCode(), "数据库更新出错");
        }
    }
}
