package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.Demo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhy
 * @version 1.0.0 2023/4/7
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

}
