package main.java.com;

public class Title58 {
    boolean isSymmetrical(TreeNode pRoot){
        //左的左，和右的右进行比较，左的右和右的左比较
        if (pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pleft, TreeNode pright) {
        if (pleft == null && pright == null){
            return true;
        }
        if (pleft == null || pright == null){
            return false;
        }
        if (pleft.val != pright.val){
            return false;
        }
        return isSymmetrical(pleft.left,pright.right) && isSymmetrical(pleft.right,pright.left);
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
