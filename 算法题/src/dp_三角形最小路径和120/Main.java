package dp_三角形最小路径和120;

import java.util.Scanner;

/** @author 燕子豪 */
public class Main {
  static int N = 500;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] triangle = new int[500][500];
    for (int i = 0; i < n; i++) {
      for (int j=0;j<=i;j++){
        triangle[i][j]=sc.nextInt();
      }
    }
    System.out.println(maximumTotal(triangle,n));
  }
  //注意:这里是最大路径和
  public static int maximumTotal(int[][] triangle,int n) {
    int[][] dp = new int[N][N];
    dp[0][0] = triangle[0][0];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + triangle[i][j];
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[n - 1][i]);
    }
    return max;
  }
}
