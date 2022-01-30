// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
// 被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
// 输入：[1,2,3,1]
// 输出：4
// 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
// 输入：[2,7,9,3,1]
// 输出：12
// 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics 数组 动态规划 👍 1859 👎 0
package dp_打家劫舍198;

/**
 * @author 燕子豪
 */
public class Solution {
  public static void main(String[] args) {
    int[]  nums={5,1,2,4,2,1};
    Solution s=new Solution();
    System.out.println(s.rob(nums));
  }
    public int rob(int[] nums) {
        int m = nums.length;
        //5.判断边界情况
        if(m==1){
            return nums[0];
        }else if(m==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        //1.定义dp数组:dp[i]表示nums数组取到前i个元素,可以打劫到的最多钱.
        int[] dp = new int[m];
        //2.初始化值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //3.填充数组
        for (int i = 2; i < m; i++) {
            //4.状态转移方程:
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[m - 1];
    }
}
