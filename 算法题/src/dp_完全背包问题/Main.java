package dp_完全背包问题;

import java.util.Scanner;

/** @author 燕子豪
 * 将完全背包问题减少为两层循环
 *简化思路:并不是那么好想,本质还是在基本做法的基础上,变换而来. 将dp[i-1][j-k*cap[i-1]]+k*val[i-1]转化为:dp[i][j - cap[i - 1]] + val[i - 1],减少了对k的循环
 * 即：发现dp[i-1][j-k*cap[i-1]]+k*val[i-1]的最大值与dp[i][j-vap[i-1]]只相差了一个val[i-1],至于怎么想出来的,或许是经验吧。
 */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 物品的个数
    int n = sc.nextInt();
    // 背包的容量
    int v = sc.nextInt();
    // 定义dp数组:dp[i][j]表示对于前i个物,背包容量为j,所装物品的最大值
    int[][] dp = new int[n + 1][v + 1];

    int[] cap = new int[n];
    int[] val = new int[n];
    for (int i = 0; i < n; i++) {
      cap[i] = sc.nextInt();
      val[i] = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      //这里必须是从小到大循环
      for (int j = 1; j <= v; j++) {
        if (j >= cap[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - cap[i - 1]] + val[i - 1]);
        }else {
          dp[i][j]=dp[i-1][j];
        }
      }
    }
    System.out.println(dp[n][v]);
  }
}
