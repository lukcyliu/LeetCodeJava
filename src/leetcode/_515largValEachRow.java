package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lukCy on 2017/4/15.
 */
public class _515largValEachRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return null;
        List<Integer> list = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int n,res;
        while (!queue.isEmpty()){
            n = queue.size();
            res = 0;
            for (int i=0;i<n;i++){
                TreeNode current = queue.poll();
                if (res <= current.val)
                    res = current.val;
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            list.add(res);
        }
        return list;
    }
}
