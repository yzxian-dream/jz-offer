package main.java.com;
/*题目描述：

  输入一棵二叉树，判断该二叉树是否是平衡二叉树。
这里的定义是：如果某二叉树中任意结点的左、右子树的深度相差不超过1，那么它就是一棵平衡二叉树。*/
public class Title39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int res = getDepth(root);
        if (res == -1) {
            return false;
        }
        return true;
    }

        private int getDepth (TreeNode root){
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int leftDepth = getDepth(root.left);
            if (leftDepth == -1) {//左子树深度为-1 说明左子树不平衡，当前子树也不平衡，返回标识-1
                return -1;
            }
            int rightDepth = getDepth(root.right);
            if (rightDepth == -1) {//遍历过程中发现子树不满足平衡条件直接返回
                return -1;
            }
            if (Math.abs(leftDepth - rightDepth) > 1) {
                return -1;
            }
            else {
                return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
            }
        }


        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
    }


