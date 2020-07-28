package main.java.com;
/*
* 题目描述：二叉树镜像

  操作给定的二叉树，将其变换为原二叉树的镜像。

  解题思路：

  求一棵树的镜像的过程：先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子结点。
* 当交换完所有的非叶结点的左、右子结点后，就可以得到该树的镜像。
* */
public class Title18 {
    public void Mirror(TreeNode root) {
        /*思路：左右结点互换*/
        if(root!=null){
            if(root.left!=null || root.right!=null){
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=temp;
                Mirror(root.left);
                Mirror(root.right);
            }
        }
    }
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
}
