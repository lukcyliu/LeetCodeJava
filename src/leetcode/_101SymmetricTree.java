package leetcode;


import java.util.Stack;

/**
 * Created by lukCy on 2017/4/13.
 */
public class _101SymmetricTree {
    //以下为递归方法
    public boolean isSymmetric(TreeNode root) {
        return  isSymmetric(root,root);

    }
    private  boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null)
            return right == null;
        else if (right == null)
            return false;
        else if (left.val == right.val){
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }
        else
            return false;
    }
    //以下为非递归方法
    public boolean isSymmetric_n(TreeNode root){
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.empty()){
            TreeNode _left = stack.pop();
            TreeNode _right = stack.pop();
            if (_right == null && _left != null)
                return false;
            else if (_left == null && _right != null)
                return false;
            else if (_left != null && _right != null){
                if (_right.val != _left.val)
                    return false;
                stack.push(_right.left);
                stack.push(_left.right);
                stack.push(_right.right);
                stack.push(_left.left);
            }
        }
        return true;
    }
}

