package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lukCy on 2017/4/13.
 */
public class leetBinTree {
    public TreeNode buildBinaryTree(int[] a){
        //把数组全部转换为节点，并存在节点列表里
        LinkedList<TreeNode>nodelist = new LinkedList<TreeNode>();
        for (int i=0;i<a.length;i++){
            nodelist.add(new TreeNode(a[i]));
        }
        for (int parentIndex=0;parentIndex<a.length/2 -1;parentIndex++){
            nodelist.get(parentIndex).left = nodelist.get(parentIndex*2 + 1);
            nodelist.get(parentIndex).right = nodelist.get(parentIndex*2 + 2);
        }
        int lastparentIndex = a.length/2 - 1;
        nodelist.get(lastparentIndex).left = nodelist.get(lastparentIndex*2 + 1);
        if (a.length % 2 == 1)
            nodelist.get(lastparentIndex).right = nodelist.get(lastparentIndex*2 +2);
        return nodelist.get(0);
    }

    public void display(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp = null;
        queue.add(root);
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.val + "-->");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

    }
}

