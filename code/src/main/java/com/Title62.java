package main.java.com;
/*
* 题目描述：二叉搜索树的第k个节点

  给定一棵二叉搜索树，请找出其中的第k小的结点。例如（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。

  解题思路：

  本题实际上比较简单，主要还是考察对树的遍历的理解，只要熟练掌握了树的三种遍历方式及其特点，解决本题并不复杂，
* 很明显本题是对中序遍历的应用。

  对于本题，我们首先可以知道二叉搜索树的特点：左结点的值<根结点的值<右结点的值。因此，我们不难得到如下结论
* ：如果按照中序遍历的顺序对一棵二叉搜索树进行遍历，那么得到的遍历序列就是递增排序的。
* 因此，只要用中序遍历的顺序遍历一棵二叉搜索树，就很容易找出它的第k大结点。*/
import java.util.ArrayList;
import java.util.List;

public class Title62 {
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null || k <= 0){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        findK(pRoot,list);////思路：二叉搜索树中序遍历正好就是递增序列
        if (list.size() < k){
            return null;
        }
        return list.get(k-1);
    }
//中序遍历
    private void findK(TreeNode pRoot, List<TreeNode> list) {
        if (pRoot == null){
            return;
        }
        if (pRoot.left != null){
            findK(pRoot.left,list);
        }
        list.add(pRoot);
        if (pRoot.right != null){
            findK(pRoot.right,list);
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
