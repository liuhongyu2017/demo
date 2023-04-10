package com.example.demo;

import com.google.common.cache.Cache;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lhy
 * @version 1.0.0 2023/4/6
 */
@AllArgsConstructor
@Component
public class DemoListener implements ApplicationListener<ApplicationStartedEvent> {

  @Resource(name = "myDataSource")
  private Cache<String, HikariDataSource> cache;

  @SneakyThrows
  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    HikariDataSource hikariDataSource = new HikariDataSource();
    hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    hikariDataSource.setJdbcUrl("jdbc:mysql://1.15.29.59:3306/jianguan_new");
    hikariDataSource.setUsername("root");
    hikariDataSource.setPassword("Tjzc@123");
    cache.put("jianguan_new", hikariDataSource);
    hikariDataSource = new HikariDataSource();
    hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    hikariDataSource.setJdbcUrl("jdbc:mysql://1.15.29.59:3306/jianguan");
    hikariDataSource.setUsername("root");
    hikariDataSource.setPassword("Tjzc@123");
    cache.put("jianguan", hikariDataSource);
  }
}
