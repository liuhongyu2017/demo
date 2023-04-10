package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hobbit.jackson.desensitize.annotation.IdCardDesensitize;

/**
 * @author lhy
 * @version 1.0.0 2023/4/7
 */
@TableName("demo")
public record Demo(
    @TableId(type = IdType.ASSIGN_ID)
    Long id,
    @IdCardDesensitize
    @TableField("name")
    String name
) {


}
