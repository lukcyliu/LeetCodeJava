package leetcode;

/**
 * Created by lukCy on 2017/4/17.
 */
public class _98ValidBST {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left))
                return false;
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;

            return isValidBST(root.right);
        }
        return true;
    }


}
