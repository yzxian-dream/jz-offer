package 二叉树的镜像;
/* 
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
import javax.swing.tree.TreeNode;
//递归
//二叉树的镜像是将二叉树的左右子树交换，因此可以写一个递归函数，每次先交换当前节点的左右子树，然后递归地交换左右子树的左右子树。
//这个不用比较节点值，所以不用新开递归函数
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right) ;
        root.left = right;
        root .right = left;
        return root;
    }
}