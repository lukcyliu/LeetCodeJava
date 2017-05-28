package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lukCy on 2017/4/13.
 */
public class _513BottomLeftValue {
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.add(root);
        int result = 0;
        int size = 0;
        while (!queue.isEmpty()){
            size = queue.size();
            for (int i=0;i<size;i++){
                current = queue.poll();
                if (i == 0)
                    result = current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }

        }
        return result;
    }
}
