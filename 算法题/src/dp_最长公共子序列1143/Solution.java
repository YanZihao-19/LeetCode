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
