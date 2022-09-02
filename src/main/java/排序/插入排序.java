package 排序;

import java.util.Arrays;

/**
 * @author lhy
 * @version 1.0.0 2022/9/2
 */
public class 插入排序 {

  public static void main(String[] args) {
    int[] arr = {2, 3, 2, 3, 45, 64, 34, 5, 6};
    for (int i = 1; i < arr.length; i++) {
      int tmp = arr[i];
      int j = i;
      while (j > 0 && tmp < arr[j - 1]) {
        arr[j] = arr[j - 1];
        j--;
      }
      if (j != i) {
        arr[j] = tmp;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
