package 换硬币_dp;

import java.util.Scanner;

/**
 * 描述给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量. 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1. 样例1
 *
 * <p>输入： [1, 2, 5] 11 输出： 3 解释： 11 = 5 + 5 + 1
 *
 * <p>输入： [2] 3 输出： -1 你可以假设每种硬币均有无数个 总金额不会超过10000 硬币的种类数不会超过500, 每种硬币的面额不会超过100
 *
 * @author 燕子豪
 */
public class Solution {

  public static int coinChange(int[] coins, int amount) {
    //1.定义dp数组 dp为一维状态数组，i表示总金额数,dp[i]表示i元钱最少硬币的组合个数
    int[] dp = new int[amount + 1];
    //2.初始化dp数组(dp[0] = 0 其余项赋值为Integer.Max_VALUE)
    dp[0] = 0;
    int num = Integer.MAX_VALUE;
    //4.遍历数组(赋值数组,从已知dp[0]开始),外层for遍历数组，内层for遍历不同金额的硬币
    for (int i = 1; i < dp.length; i++) {
      dp[i] = num;
      //3.状态转移方程: dp[i] = Min(dp[i-1],dp[i-2],dp[i-5]) + 1
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0 && dp[i - coins[j]] != num) {
          dp[i] = Integer.min(dp[i - coins[j]] + 1, dp[i]);
        }
      }
    }
    return dp[amount] == num ? -1 : dp[amount];
  }
}
