// 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
//
// 第 i 种物品的体积是 vi，价值是 wi。
//
// 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
// 输出最大价值。
//
// 输入格式
// 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
//
// 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
//
// 输出格式
// 输出一个整数，表示最大价值。
//
// 数据范围
// 0<N,V≤1000
// 0<vi,wi≤1000
// 输入样例
// 4 5
// 1 2
// 2 4
// 3 4
// 4 5
// 输出样例：
// 10
package dp_完全背包问题;

import java.util.Scanner;

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

    for (int i=1;i<=n;i++){
      for (int j=v;j>=1;j--){
        for (int k=0;cap[i-1]*k<=j;k++){
          dp[i][j]=Math.max(dp[i-1][j-cap[i-1]*k]+k*val[i-1],dp[i][j]);
        }
      }
    }
    System.out.println(dp[n][v]);
  }
}
