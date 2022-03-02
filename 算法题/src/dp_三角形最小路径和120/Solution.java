// 给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
// 正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
// 示例 1：
//
//
// 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// 输出：11
// 解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
// 4 1 8 3
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
// 输入：triangle = [[-10]]
// 输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10⁴ <= triangle[i][j] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//
// Related Topics 数组 动态规划 👍 946 👎 0
package dp_三角形最小路径和120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** @author 燕子豪 */
public class Solution {
  static int N = 210;
  public static void main(String[] args) {
//    [[2],[3,4],[6,5,7],[4,1,8,3]]
    int[][] dp = new int[N][N];
    List<List<Integer>> triangle=new LinkedList<>();
    List<Integer> l1=new ArrayList<>();
    l1.add(2);
    List<Integer> l2=new ArrayList<>();
    l2.add(3);
    l2.add(4);
    List<Integer> l3=new ArrayList<>();
    l3.add(6);
    l3.add(5);
    l3.add(7);
    List<Integer> l4=new ArrayList<>();
    l4.add(4);
    l4.add(1);
    l4.add(8);
    l4.add(3);
    triangle.add(l1);
    triangle.add(l2);
    triangle.add(l3);
    triangle.add(l4);
    System.out.println(minimumTotal(triangle,dp));
  }
  public static int minimumTotal(List<List<Integer>> triangle,int[][] dp) {
    dp[0][0] = triangle.get(0).get(0);
    int n=triangle.size();
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      min = Math.min(min, dp[n - 1][i]);
    }
    return min;
  }
}
