//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划 👍 2175 👎 0
package dp_最长递增子序列300;

/**
 * @author 燕子豪
 */
public class Solution {
  public static void main(String[] args) {
    int[] nums={8,5,1,6,8,2,4,9,10};
    System.out.println(longestAscendingSubsequence(nums));
  }
  static int longestAscendingSubsequence(int[] nums){
      int n=nums.length;
      //1.定义dp数组:dp[i]表示以nums数组第i元素结尾的最长子序列的长度
      int[] dp=new int[n];
      //3.初始化值,令dp[0]=1,且若后续元素都nums[i]<nums[j],则令dp[i]=1
      dp[0]=1;
      //4.遍历数组(从初始值开始)
      for(int i=1;i<n;i++){
          for (int j=0;j<i;j++){
              if(nums[j]<nums[i]){
                  //2.状态转移方程:遍历第dp[i]前的所有元素，找出满足nums[i]>nums[j]且dp[j]最大的元素，令dp[i]=dp[j]+1
                  dp[i]=Math.max(dp[i],dp[j]+1);
              }else if (dp[i]==0){
                  dp[i]=1;
              }
          }
      }
      //取dp数组的最大值为结果
      int ans=dp[0];
      for (int i=0;i<dp.length;i++){
          if(dp[i]>ans){
              ans=dp[i];
          }
      }
      return ans;
  }
}
