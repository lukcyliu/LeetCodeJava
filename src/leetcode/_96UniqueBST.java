package leetcode;

/**
 * Created by lukCy on 2017/4/28.
 * G(n)为1~n可以构成的唯一BST的个数，
 * G(n) = f(1,n) + f(2,n) + ... + f(n,n);
 * 其中：f(i,n)表示以i为根节点的BST个数
 * 又，i为根节点，其左子树可能以1~i-1为根节点，右子树可能以i+1~n为根节点
 * 所以f(i,n) = G(i-1)* G(n-i);
 * 即，G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(i-1)*G(n-i) + ... + G(n-1)*G(0)
 */
public class _96UniqueBST {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<n+1;i++){
            for (int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _96UniqueBST().numTrees(3));
    }
}
