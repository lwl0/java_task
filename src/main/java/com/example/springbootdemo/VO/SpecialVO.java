package com.example.springbootdemo.VO;

import com.example.springbootdemo.entity.DataClean1;
import lombok.Data;

import java.util.List;

/**
 * @Author : liwenlong
 * @Date: 2022/7/7
 */
@Data
public class SpecialVO {
    private Object data;
    private long time;
    private boolean isCache;
}
