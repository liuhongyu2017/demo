package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.mapper.DemoMapper;
import com.example.demo.model.Demo;
import com.google.common.cache.Cache;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhy
 * @version 1.0.0 2023/4/6
 */
@RequiredArgsConstructor
@RestController
public class DemoController {

  @Resource(name = "myDataSource")
  private Cache<String, HikariDataSource> cache;

  private final DemoMapper demoMapper;

  @GetMapping("/demo")
  public Map<String, Object> demo() throws ExecutionException {
    HikariDataSource dataSource = cache.get("jianguan_new", () -> {
      throw new RuntimeException("找不到数据源");
    });
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    return jdbcTemplate.queryForMap("select count(1) from entity_info");
  }

  @GetMapping("/demo2")
  public Map<String, Object> demo2() throws ExecutionException {
    HikariDataSource dataSource = cache.get("jianguan", () -> {
      throw new RuntimeException("找不到数据源");
    });
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    return jdbcTemplate.queryForMap("select count(1) from entity_info");
  }

  @GetMapping("/demo3")
  public List<Demo> demo3() {
    List<Demo> demos = demoMapper.selectList(Wrappers.query());
    for (Demo demo : demos) {
      System.out.println(demo.id());
    }
    return demos;
  }
}
