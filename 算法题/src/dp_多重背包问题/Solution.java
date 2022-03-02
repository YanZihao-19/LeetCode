// 有 N 种物品和一个容量是 V 的背包。
//
// 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
//
// 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
// 输出最大价值。
//
// 输入格式
// 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
//
// 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
//
// 输出格式
// 输出一个整数，表示最大价值。
//
// 数据范围
// 0<N,V≤100
// 0<vi,wi,si≤100
// 输入样例
/* 4 5
 1 2 3
 2 4 1
 3 4 3
 4 5 2*/
// 输出样例：
// 10
package dp_多重背包问题;

import java.util.Scanner;

/**
 * @author 燕子豪
 */
public class Solution {
    static int N=1010;
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int v=sc.nextInt();
      //体积
      int[] vol=new int[N];
      //价值
      int[] val=new int[N];
      //数量
      int[] qua=new int[N];
      //定义dp数组：dp[i][j]表示针对前i个物品,背包容量为j时所能够装物品的最大价值
      int[][] dp=new int[N][N];

      for (int i=1;i<=n;i++){
          vol[i]=sc.nextInt();
          val[i]=sc.nextInt();
          qua[i]=sc.nextInt();
      }

      for (int i=1;i<=n;i++){
          for (int j=v;j>=1;j--){
              dp[i][j]=dp[i-1][j];
              for (int k=1;k<=qua[i]&&j>=k*vol[i];k++){
                  dp[i][j]=Math.max(dp[i][j],dp[i][j]=dp[i-1][j-k*vol[i]]+k*val[i]);
              }
          }
      }
      System.out.println(dp[n][v]);
  }
}
