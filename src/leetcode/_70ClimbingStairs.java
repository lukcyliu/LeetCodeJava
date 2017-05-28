package leetcode;

/**
 * Created by lukCy on 2017/4/24.
 */
public class _70ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int ans = climbingStairs(n);
        System.out.println(String.valueOf(ans));
    }
    public static int dp(int sum,int ans){
        if(sum == 0 || sum == 1)
            return ans +=1;
        return dp(sum-1,ans) + dp(sum-2,ans);
    }
    public static int climbingStairs(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int[] ans = new int[n];
        ans[0] = 1;ans[1] = 2;
        for(int i = 2;i<n;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans[n-1];
    }
}
