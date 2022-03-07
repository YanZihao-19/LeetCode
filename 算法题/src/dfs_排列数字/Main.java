// 给定一个整数 n，将数字 1∼n 排成一排，将会有很多种排列方法。
//
// 现在，请你按照字典序将所有的排列方法输出。
//
// 输入格式
// 共一行，包含一个整数 n。
//
// 输出格式
// 按字典序输出所有排列方案，每个方案占一行。
//
// 数据范围
// 1≤n≤7
// 输入样例：
// 3
// 输出样例：
// 1 2 3
// 1 3 2
// 2 1 3
// 2 3 1
// 3 1 2
// 3 2 1
package dfs_排列数字;

import java.util.Scanner;

/** @author 燕子豪 */
public class Main {
  static int N = 10;
  static int[] path = new int[N];
  static boolean[] state = new boolean[N];
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dfs(0);
  }

  static void dfs(int u) {
    // 如果到了递归最后一层，输出path
    if (u == n) {
      for (int i = 0; i < n; i++) {
        System.out.print(path[i] + " ");
      }
      System.out.println();
    }
    // 填充path,这里的n是指1~n,遍历每个数字(从1开始)
    for (int i = 1; i <= n; i++) {
      // 如果该数字没有被填充，则填充该数字
      if (!state[i]) {
        path[u] = i;
        // 并标记该数字的状态为填充过了
        state[i] = true;
        // 搜索下一层,当u==n时,输出path
        dfs(u + 1);
        // 回溯
        state[i] = false;
      }
    }
  }
}
