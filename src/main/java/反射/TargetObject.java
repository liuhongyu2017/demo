package 反射;

/**
 * @author lhy
 * @version 1.0.0 2023/8/4
 */
public class TargetObject {

  private String value;

  public TargetObject() {
    value = "JavaGuide";
  }

  public void publicMethod(String s) {
    System.out.println("I love " + s);
  }

  private void privateMethod() {
    System.out.println("value is " + value);
  }
}
