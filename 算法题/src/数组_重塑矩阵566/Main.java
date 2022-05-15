//在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
//
//
// 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
//
// 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
//
// 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
//
//
//
// 示例 1：
//
//
//输入：mat = [[1,2],[3,4]], r = 1, c = 4
//输出：[[1,2,3,4]]
//
//
// 示例 2：
//
//
//输入：mat = [[1,2],[3,4]], r = 2, c = 4
//输出：[[1,2],[3,4]]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// -1000 <= mat[i][j] <= 1000
// 1 <= r, c <= 300
//
// Related Topics 数组 矩阵 模拟 👍 308 👎 0
package 数组_重塑矩阵566;

/**
 * leetcode556 重塑矩阵-数组
 *
 * @author 燕子豪
 * @date 2022/5/15
 */
public class Main {
  public static void main(String[] args) {
    int[][] mat = {{1, 2}, {3, 4}};
    int r = 1;
    int c = 4;
    int[][] ans = matrixReshape(mat, r, c);
    for (int[] arr : ans) {
      for (int i : arr) {
        System.out.print(i + " ");
      }
    }
  }
  /**
   * 思路1:复杂度O(m*n),首先判断两数组是否能转化，若不能转化直接返回ans，若能转化则直接复制到目标数组中，
   *      需要注意直接复制二位数组时的写法：ans[i / c][i % c] = mat[i / n][i % n];
   * */
  public static int[][] matrixReshape(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (m * n != r * c) {
      return mat;
    }
    int[][] ans = new int[r][c];
    for (int i = 0; i < m * n; i++) {
      ans[i / c][i % c] = mat[i / n][i % n];
    }
    return ans;
  }
  /**
   * 思路2:复杂度O(m*n),首先判断两数组是否能转化，若不能转化直接返回ans，若能转化则将原数组复制到一个临时的一维数组中，、
   *      再将一维数组复制到目标数组中即可。
   * */
  public static int[][] matrixReshape2(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (m * n != r * c) {
      return mat;
    }
    int cont = 0;
    int[] temp = new int[m * n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        temp[cont++] = mat[i][j];
      }
    }
    cont = 0;
    int[][] ans = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        ans[i][j] = temp[cont++];
      }
    }
    return ans;
  }
}
