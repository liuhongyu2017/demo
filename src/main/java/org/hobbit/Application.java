package org.hobbit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhy
 * @version 1.0.0 2023/9/19
 */
public class Application {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    User user = applicationContext.getBean(User.class);
    System.out.println(user.getName());
  }
}
