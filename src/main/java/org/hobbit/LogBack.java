package org.hobbit;

/**
 * @author lhy
 * @version 1.0.0 2023/12/4
 */
public class LogBack implements Log {

  @Override
  public void log(String info) {
    System.out.println("LogBack:" + info);
  }
}
