package com.example.demo;

/**
 * @author lhy
 * @version 1.0.0 2023/4/6}
 */
public enum DemoEnum implements DemoInterface {

  MENU1(1L, "菜单1"),
  MENU2(2L, "菜单2"),
  MENU3(3L, "菜单3"),
  MENU4(4L, "菜单4"),
  ;

  DemoEnum(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  private final Long id;

  private final String name;

  @Override
  public String getKey() {
    return "menu";
  }

  @Override
  public String getTitle() {
    return "菜单";
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public String getName() {
    return this.name;
  }
}
