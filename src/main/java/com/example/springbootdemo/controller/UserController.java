package com.example.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.common.Result;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController    // 表示这是一个控制器
@RequestMapping("/user")// 路由
public class UserController {

    @Autowired// 自动注入
    UserMapper userMapper;     //并不规范，应该是三层结构，这里为了方便，直接放在这里

    //新增用户
    @PostMapping("/new")
    public Result<?> save(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success();
    }

    //更新用户
    @PutMapping("/update")
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.success();
    }
    //删除用户
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        userMapper.deleteById(id);
        return Result.success();
    }

    //分页查询
    @GetMapping
    public Result<?> findPage( @RequestParam(defaultValue = "1") Integer pageNum,       //defaultValue = "1" 表示默认值为1
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "" ) String search) {   //当前页，每页显示条数,搜索条件
        /*Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pagesize), Wrappers.<User>query().like("username", search));
        return Result.success(userPage);*/
        /**
         * 为了为空的时候不报错，改成下面的写法
         */
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(search != null && !"".equals(search)){
            wrapper.like(User::getNickName, search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(userPage);
    }

}
