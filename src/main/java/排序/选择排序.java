package 排序;

import java.util.Arrays;

/**
 * @author lhy
 * @version 1.0.0 2022/9/2
 */
public class 选择排序 {

  public static void main(String[] args) {
    int[] arr = {2, 3, 2, 3, 45, 64, 34, 5, 6};
    int len = arr.length;
    int minIndex, temp;
    for (int i = 0; i < len - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < len; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
        temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
