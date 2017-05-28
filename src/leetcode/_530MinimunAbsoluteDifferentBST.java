package leetcode;

/**
 * Created by lukCy on 2017/5/17.
 * 中序遍历BST，判断前后两个value的差是否需要被替换。
 */
public class _530MinimunAbsoluteDifferentBST {
    int result = Integer.MAX_VALUE;
    int lastVal = -1;
    public int getMinimumDifference(TreeNode root){

        inOrdetTraversal(root);
        return result;
    }
    public void inOrdetTraversal(TreeNode root){
        if (root == null || root.val == 0)
            return;
        inOrdetTraversal(root.left);
        if (lastVal >= 0) {
            int tmp = root.val - lastVal;
            if (tmp <= result)
                result = tmp;
        }
        lastVal = root.val;
        inOrdetTraversal(root.right);
    }

}
