package org.hobbit;

/**
 * @author lhy
 * @version 1.0.0 2023/12/4
 */
public class Log4j implements Log {

  @Override
  public void log(String info) {
    System.out.println("Log4j:" + info);
  }
}
