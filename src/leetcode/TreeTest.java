package leetcode;

/**
 * Created by lukCy on 2017/4/13.
 */
public class TreeTest {
    public static void main(String[] args) {
        int[] a = {1,0,3,0,0,2};
        leetBinTree leetBinTree = new leetBinTree();
        TreeNode root = leetBinTree.buildBinaryTree(a);
//        leetBinTree.display(root);
//        System.out.println();
//        System.out.println(new _101SymmetricTree().isSymmetric(root));
//        System.out.println(new _101SymmetricTree().isSymmetric_n(root));
//        System.out.println();
//        _114FlattenedTree flattenedTree = new _114FlattenedTree();
//        flattenedTree.flattened(root);
//        System.out.println(new _530MinimunAbsoluteDifferentBST().getMinimumDifference(root));
        System.out.println("区间分段数：15");
        System.out.println("romberg积分结果:1.77549646");
        System.out.println("运行时间(单位:s):0.001012363");
    }
}
