package dp_01背包问题;

import java.util.Scanner;

/** @author 燕子豪 采用一维数组在空间上简化01背包问题
 * 只有空间上的转化，并未简化时间复杂度
 * */
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 物品的个数
    int n = sc.nextInt();
    // 背包的容量
    int v = sc.nextInt();
    // 定义dp数组:dp[i][j]表示对于前i个物,背包容量为j,所装物品的最大值
    int[] dp= new int[v + 1];

    int[] cap = new int[n];
    int[] val = new int[n];
    for (int i = 0; i < n; i++) {
      cap[i] = sc.nextInt();
      val[i] = sc.nextInt();
    }

    // 填充数组
    for (int i = 1; i <= n; i++) {
      //注意内层的遍历必须是从大到小进行的
      for (int j = v; j >= cap[i-1]; j--) {
        dp[j]=Math.max(dp[j],dp[j-cap[i-1]]+val[i-1]);
      }
    }
    System.out.println(dp[v]);
  }
}
