package 对称的二叉树;
/* 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
import javax.swing.tree.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) ) {
            return true;
        }
        return f(root.left,root.right);
    }

    public boolean f(TreeNode A,TreeNode B) {
      
       if (A == null && B == null) {
        return true;
       }
       if (A == null || B==null) {
        return false;
       }
       //这个比较要放在最下面，不然如果A.left==null时，方上面，直接空指针了
       if (A.val != B.val) {
        return false;
    }
       return f(A.left, B.right) && f(A.right,B.left);
    }
} 