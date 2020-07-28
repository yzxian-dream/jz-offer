package main.java.com;
/*题目描述：

  输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
最长路径的长度为树的深度。*/
public class Title38 {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return 1 + depth;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
