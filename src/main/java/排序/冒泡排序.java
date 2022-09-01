package 排序;

import java.util.Arrays;

/**
 * @author lhy
 * @version 1.0.0 2022/9/1
 */
public class 冒泡排序 {

  public static void main(String[] args) {
    int[] arr = {2, 3, 2, 3, 45, 64, 34, 5, 6};
    int len = arr.length - 1;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
