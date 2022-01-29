// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
// horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
// 输入：word1 = "intention", word2 = "execution"
// 输出：5
// 解释：
// intention -> inention (删除 't')
// inention -> enention (将 'i' 替换为 'e')
// enention -> exention (将 'n' 替换为 'x')
// exention -> exection (将 'n' 替换为 'c')
// exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划 👍 2072 👎 0
package dp_编辑距离72;

/** @author 燕子豪 */
public class Solution {
  public static void main(String[] args) {
    String word1 = "grfefs";
    String word2 = "gesaffg";
    System.out.println(minDistance(word1, word2));
  }

  static int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if(m==0||n==0){
      return m==0?n:m;
    }
    // 1.定义dp数组
    int[][] dp = new int[m + 1][n + 1];

    // 2.初始化值
    for (int i = 0; i < m + 1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < n + 1; j++) {
      dp[0][j] = j;
    }

    // 3.填充数组
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        //4.状态转移方程(若word1[i]==word2[j]则dp[i][j]=dp[i-1][j-1])
        if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          //否则取令dp[i][j]= min(dp[i][j], dp[i-1][j], dp[i][j-1])+1
          dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
          dp[i][j]=Math.min(dp[i-1][j-1]+1,dp[i][j]);
        }
      }
    }
    return dp[m][n];
  }
}
