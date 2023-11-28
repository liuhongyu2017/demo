package org.hobbit;

/**
 * @author lhy
 * @version 1.0.0 2023/11/24
 */
public class User {

  public User(String name) {
    this.name = name;
  }

  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
