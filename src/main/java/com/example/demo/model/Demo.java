package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author lhy
 * @version 1.0.0 2023/4/7
 */
@TableName("demo")
public record Demo(
    @TableId(type = IdType.ASSIGN_ID)
    Long id,
    @TableField("name")
    String name
) {


}
