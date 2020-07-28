package main.java.com;
//1.判断该树中是否存在根节点叶子节点的路径，这条路径上所有的节点值相加等于目标和
//递归
/*public class Title24 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }

        boolean result1 = hasPathSum(root.left,sum);
        boolean result2 = hasPathSum(root.right,sum);
        return result1 || result2;

    }*/


   /* public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return (sum - node.val == 0);
        }
        boolean result1 = hasPathSum(node.left, sum - node.val);
        boolean result2 = hasPathSum(node.right, sum - node.val);
        return result1 || result2;
    }*/


import java.util.ArrayList;

//题目描述：
   //
   //  输入一颗二叉树的根结点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
   // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
   public class Title24 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));//直接加list只是保存了当前地址，需要重新开辟地址，将list中数据传入
        }
        /* if(root.left != null){
        FindPath(root.left,target);
        }
        if (root.right != null){
        FindPath(root.right,target);
        }*/
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);//退回到上一个节点找右节点96 v
        return result;
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
