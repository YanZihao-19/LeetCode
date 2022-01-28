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
