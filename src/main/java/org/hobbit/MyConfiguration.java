package org.hobbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lhy
 * @version 1.0.0 2023/11/24
 */
@Configuration
public class MyConfiguration {

  @Bean
  public User user() {
    return new User("张三");
  }
}
