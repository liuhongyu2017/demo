package 其他;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author lhy
 * @version 1.0.0 2022/6/23
 */
public class Application {



  /**
   * 最小的 K 个数
   */
  public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int num : nums) {
      queue.add(num);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    return new ArrayList<>(queue);
  }

  /**
   * 栈的压入、弹出序列
   */
  public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
    int l = pushSequence.length;
    Stack<Integer> stack = new Stack<>();
    for (int pushIndex = 0, popIndex = 0; pushIndex < l; pushIndex++) {
      stack.push(pushSequence[pushIndex]);
      while (popIndex < l && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return stack.isEmpty();
  }

  /**
   * 包含 min 函数的栈
   */
  static class MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
      stack1.push(node);
      stack2.push(stack2.isEmpty() ? node : Math.min(stack2.peek(), node));
    }

    public int pop() {
      stack2.pop();
      return stack1.pop();
    }

    public int top() {
      return stack1.peek();
    }

    public int min() {
      return stack2.peek();
    }
  }

  /**
   * 通过栈实现队列功能
   */
  static class Queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
      stack1.push(node);
    }

    public int pop() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      if (stack2.isEmpty()) {
        return -1;
      }
      return stack2.pop();
    }
  }

  /**
   * 查找第一次出现的重复字符
   */
  public static int firstNotRepeatingChar2(String str) {
    BitSet b1 = new BitSet(128);
    BitSet b2 = new BitSet(128);

    char[] chars = str.toCharArray();
    for (char c : chars) {
      if (!b1.get(c) && !b2.get(c)) {
        b1.set(c);
      } else if (b1.get(c) && !b2.get(c)) {
        b2.set(c);
      }
    }

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (b1.get(c) && !b2.get(c)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 顺时针打印矩阵
   */
  public static List<Integer> printMatrix(int[][] matrix) {
    // 上 下 左 右
    int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
    List<Integer> res = new ArrayList<>();
    while (r1 <= r2 && c1 <= c2) {
      // 上
      for (int i = c1; i <= c2; i++) {
        res.add(matrix[r1][i]);
      }
      // 右
      for (int i = r1 + 1; i <= r2; i++) {
        res.add(matrix[i][c2]);
      }
      // 下
      if (r1 != r2) {
        for (int i = c2 - 1; i >= c1; i--) {
          res.add(matrix[r2][i]);
        }
      }
      // 左
      if (c1 != c2) {
        for (int i = r2 - 1; i >= r1 + 1; i--) {
          res.add(matrix[i][c1]);
        }
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return res;
  }

  /**
   * 替换空格
   */
  public static String replaceSpace(StringBuffer str) {
    int P1 = str.length() - 1;
    for (int i = 0; i <= P1; i++) {
      if (str.charAt(i) == ' ') {
        str.append("  ");
      }
    }
    int P2 = str.length() - 1;
    while (P1 >= 0 && P2 > P1) {
      char c = str.charAt(P1--);
      if (c == ' ') {
        str.setCharAt(P2--, '0');
        str.setCharAt(P2--, '2');
        str.setCharAt(P2--, '%');
      } else {
        str.setCharAt(P2--, c);
      }
    }

    return str.toString();
  }

  /**
   * 查找重复项
   */
  public static int duplicate(int[] nums) {
    Map<Integer, Integer> itemMap = new HashMap<>();
    for (int num : nums) {
      Integer itemInt = itemMap.get(num);
      if (itemInt != null) {
        return itemInt;
      }
      itemMap.put(num, num);
    }
    return -1;
  }

  /**
   * 查找制定数字
   */
  public boolean find(int target, int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int rows = matrix.length, cols = matrix[0].length;
    int r = 0, c = cols - 1;
    while (r <= rows - 1 && c >= 0) {
      if (target == matrix[r][c]) {
        return true;
      } else if (target > matrix[r][c]) {
        r++;
      } else {
        c--;
      }
    }
    return false;
  }
}
