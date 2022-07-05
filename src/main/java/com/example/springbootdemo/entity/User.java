package com.example.springbootdemo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@TableName("user")
@Data
public class User {
    @TableId(type = AUTO)           //主键策略
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
}
