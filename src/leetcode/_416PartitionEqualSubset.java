package leetcode;

/**
 * Created by lukCy on 2017/5/2.
 * 解题思路：一：子问题：dp[i]表示判断数组是否存在和为i的子集；
 *             最有子结构：dp[i] = dp[i - a[k]];
 *          二：转换为01背包，求前i个物品，容量为j，其最大价值dp[i][j] = sum/2;
 *
 */
public class _416PartitionEqualSubset {
    public boolean canPatition(int[] nums){
        int n = nums.length;
        int sum = 0;
        for (int num:nums) sum += num;
        if (sum%2 == 1) return false;
        else{
            sum /= 2;
            int[][] dp = new int[n][sum+1];

            for (int i=nums[0];i<=sum;i++){
                dp[0][i] = nums[0];
            }
            //遍历nums,自下而上动态规划
            for (int i=1;i<n;i++){
                for (int j=nums[i];j<=sum;j++){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
                }
            }

            if (dp[n-1][sum] == sum)
                return true;
            else
                return false;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,4};
        System.out.println(new _416PartitionEqualSubset().canPatition(nums));
    }
}
