//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//
//
//
// 示例 1：
//
//
//输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
//
//
// 示例 2：
//
//
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
//
//
// 示例 3：
//
//
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
//
//
//
//
// 提示：
//
//
// 1 <= text1.length, text2.length <= 1000
// text1 和 text2 仅由小写英文字符组成。
//
// Related Topics 字符串 动态规划 👍 821 👎 0
package dp_最长公共子序列1143;

/**
 * @author 燕子豪
 */
public class Solution {
  public static void main(String[] args) {
    String text1 = "bfgh";
    String text2 = "abefh";
    Solution s = new Solution();
    System.out.println(s.longestCommonSubsequence(text1, text2));
  }

  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();

    // 1、定义dp数组:dp[i][j]:表示text1(0~i)个字符与text2(0~j)个字符公共子序列的长度
    int[][] dp = new int[m][n];
    // 2、初始化值
    for (int i = 0; i < m; i++) {
      if (s1[i] == s2[0] && dp[i][0] == 0) {
        dp[i][0] = 1;
      } else if (i > 0 && dp[i - 1][0] == 1) {
        dp[i][0] = 1;
      }
    }
    for (int j = 0; j < n; j++) {
      if (s2[j] == s1[0] && dp[0][j] == 0) {
        dp[0][j] = 1;
      } else if (j > 0 && dp[0][j - 1] == 1) {
        dp[0][j] = 1;
      }
    }

    // 4、填充数组
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        //3.状态转移方程:如果s1[i]==s2[j],则dp[i][j]=dp[i-1][j-1]+1;
        if (s1[i] == s2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
