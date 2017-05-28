package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lukCy on 2017/4/19.
 */
public class _114FlattenedTree {
    public void flattened(TreeNode root){
        if (root == null)
            return;
        flattened(root.left);
        flattened(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null)
            root = root.right;
        root.right = right;
        }
        //非递归使用堆栈
        public void flattened_n(TreeNode root){
            if (root == null)
                return;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode node = null;
            while (!stack.isEmpty()){
                node = stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                node.left = null;
                if (stack.isEmpty()){
                    node.right = null;
                }
                else{
                    node.right = stack.peek();
                }
            }
        }


    }

