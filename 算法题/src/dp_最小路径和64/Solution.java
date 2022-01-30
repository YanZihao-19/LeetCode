// 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
// 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
// 输出：7
// 解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
// 输入：grid = [[1,2,3],[4,5,6]]
// 输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵 👍 1126 👎 0
package dp_最小路径和64;

/** @author 燕子豪 */
public class Solution {
  public static void main(String[] args) {
    //
    int[][] grid = {{1, 2, 3}, {4, 5, 6}};
    System.out.println(minPathSum(grid));
  }

  public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // 1.定义dp数组
    int[][] dp = new int[m][n];
    // 3.初始化dp数组
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    //4.遍历(填充)dp数组
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // 2.状态转移方程
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }
}
