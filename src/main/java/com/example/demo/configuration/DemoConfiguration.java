package com.example.demo.configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhy
 * @version 1.0.0 2023/4/6
 */
@Configuration
public class DemoConfiguration {

  @Bean
  public Cache<String, HikariDataSource> myDataSource() {
    return CacheBuilder.newBuilder()
        .concurrencyLevel(Runtime.getRuntime().availableProcessors())
        .build();
  }
}
