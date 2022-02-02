package dp_最大子数组和53;

/**
 * @author 燕子豪
 */
public class Solution {
  public static void main(String[] args) {
    int[] nums={1,2,3,4,5};
    Solution s=new Solution();
    System.out.println(s.maxSubArray(nums));
  }
  public int maxSubArray(int[] nums) {
    int m=nums.length;
    //1.定义dp数组
    int[] dp=new int[m];
    //2.初始化值
    dp[0]=nums[0];
    //3.填充数组
    for (int i=1;i<m;i++){
      //状态转移方程
      if(dp[i-1]<0){
        dp[i]=nums[i];
      }else {
        dp[i]=dp[i-1]+nums[i];
      }
    }
    int max=dp[0];
    for (int i=1;i<m;i++){
      if(dp[i]>max){
        max=dp[i];
      }
    }
    return max;
  }
}
