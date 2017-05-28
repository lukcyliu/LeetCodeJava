package leetcode;

/**
 * Created by lukCy on 2017/4/28.
 * 排坑：题目说的是求最长回文子序列，比如bbbab，子序列不要求连续，子字符串才要求连续，
 *      所以这里面bbb和b加起来就构成了一个长度为4的回文子序列bbbb
 * 思路：1、递归求解；
 *      2、动态规划；
 */
public class _516LongestPalindromicSubsequence {
    //递归方法超时tle---------------------------------------//
    public int longestPalindromeSubseq_dg(String s){
        int n = s.length();
        return lps(s,0,n-1);
    }
    public int lps(String s,int i,int j){
        if (i == j)
            return 1;
        if (i>j)
            return 0;
        if (s.charAt(i) == s.charAt(j))
            return lps(s,i+1,j-1) + 2;
        else
            return Math.max(lps(s,i,j-1),lps(s,i+1,j));
    }
    //-------------------递归end----------------------------//

    //dp:取出i>j的情况---------------------------------------//
    public int longestPalindromeSubseq(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        //在n^2的for loop里的第一层对i的loop和在外部给dp[i][i]赋值的loop是重合的，可以直接取代
        for (int i=n-1;i>=0;i--){
            dp[i][i] = 1;
            for (int j = i+1;j<n;j++){
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
    //end---------------------------------------------------//
    public static void main(String[] args) {
        String s = "aabaaba";
        System.out.println(new _516LongestPalindromicSubsequence().longestPalindromeSubseq(s));
    }
}
