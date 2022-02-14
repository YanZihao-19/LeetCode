package dp_01背包问题;

import java.util.Scanner;

/** @author 燕子豪 */
public class Solution {
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

    // 初始化dp数组
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }
    for (int j = 0; j <= v; j++) {
      dp[0][j] = 0;
    }

    // 填充数组
    for (int i = 1; i <= n; i++) {
      for (int j = v; j >= 1; j--) {
        if(j>=cap[i-1]){
          //如果可以装下则比较装了第i个物品和不装第i个物品,取两者最大值
          dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-cap[i-1]]+val[i-1]);
        }else {
          //装不下则取dp[i-1][j]
          dp[i][j]=dp[i-1][j];
        }
      }
    }
    System.out.println(dp[n][v]);
  }
}
