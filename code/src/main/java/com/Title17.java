package main.java.com;
/*
*题目描述：树的子结构

  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

  解题思路：

  要查找树A中是否存在和树B结构一样的子树，我们可以分为两步：第一步，在树A中找到和树B的根结点值一样的结点R；
* 第二步，判断树A中以R为根结点的子树是不是包含和树B一样的结构。

  对于这两步，第一步实际上就是树的遍历，第二步是判断是否有相同的结构，这两步都可以通过递归来实现。
* */
public class Title17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {//找相同根节点
        if(root1==null || root2==null)
            return false;
        boolean res=false;
        if(root1.val==root2.val) //有相同的根节点，判断第二步
            res=doesTree1HasTree2(root1,root2);
        if(!res) //不满足，继续在子树中查找
            res=HasSubtree(root1.left,root2); //左子树
        if(!res) //左子树也没有找到，右子树查找
            res=HasSubtree(root1.right,root2); //右子树
        return res;
    }
    //以R为根的子树是否包含和树B相同的结构
    public boolean doesTree1HasTree2(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return doesTree1HasTree2(root1.left,root2.left) && doesTree1HasTree2(root1.right,root2.right);
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
