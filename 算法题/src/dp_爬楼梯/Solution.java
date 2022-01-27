package dp_爬楼梯;

/**
 * @author 燕子豪
 */
public class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        //1.定义dp数组：dp[i]中i表示i层楼梯,dp[i]表示i层楼梯由dp[i]中方式
        int[] dp=new int[n+1];
        //3.初始化数组
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        //4.遍历数组(填充数组,从初始化值开始)
        for(int i=3;i<dp.length;i++){
            //2.状态转移方程
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
