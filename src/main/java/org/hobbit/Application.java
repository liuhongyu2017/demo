package org.hobbit;

/**
 * @author lhy
 * @version 1.0.0 2023/9/19
 */
public class Application {

  public static void main(String[] args) {
    var name = "张三";
    var age = 18;
    var json = STR."""
{
    "user":"\{name}",
    "age:\{age}
}
""";
    System.out.println(json);
  }
}
