package algorithm.trees;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 */
public class BinaryTreeDepth {
    public static void main(String[] args) {

    }
    //递归
    public static int getTreeDepth(TreeNode root){
        return  root==null?0:1+Math.max(getTreeDepth(root.left),getTreeDepth(root.right));
    }
}
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
