package application;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author lhy
 * @version 1.0.0 2022/05/07
 */
public class Application {

  public static void main(String[] args) {
    BiMap<Integer, String> empIDNameMap = HashBiMap.create();

    empIDNameMap.put(101, "Mahesh");
    empIDNameMap.put(102, "Sohan");
    empIDNameMap.put(103, "Ramesh");

    System.out.println(empIDNameMap.get(102));
  }
}
