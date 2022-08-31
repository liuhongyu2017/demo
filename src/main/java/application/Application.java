package application;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author lhy
 * @version 1.0.0 2022/05/07
 */
public class Application {

  public static void main(String[] args) {
    Integer a = new Integer(123);
    Integer b = new Integer(123);
    System.out.println(a == b);
  }
}
