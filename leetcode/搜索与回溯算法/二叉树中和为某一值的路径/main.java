package 搜索与回溯算法.二叉树中和为某一值的路径;
import java.util.ArrayList;
/* 
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
叶子节点 是指没有子节点的节点。
 */
import java.util.List;

import javax.swing.tree.TreeNode;
   /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//采用深搜回溯来做
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(root,target);
        return res;
    }
    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            //这一步要用new ArrayList来做是为了使temp在后面的add的时候是在前一次的基础上，而不会重新给个空的arraylist//
            //也就知道了作者的意图：力扣的该题涉及到回溯，也就是每次有满足条件的结果就会被存入temp，不满足就回溯，如果直接写 temp.add(path)，
            //因为path为一个引用类型，即内存中只有一份，那么每一次temp所add的path都是取得同一个path，
            //即后面path的每一个改变均会对temp.add(path)中的path有影响（会导致最终每次存入的path都是同一个值）。
            //这个temp是全局变量，所以要重新定义，不能直接add(temp)
            res.add(new ArrayList<>(temp));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        //回溯回来删除最后add的那个不符合条件的叶子结点
        //走到这一步时的root一定是一个叶子结点，所以，dfs（left）和dfs(right)都会被root==null return 回来，然后执行remove移除不满足条件的结点
        temp.remove(temp.size()-1);
        //如果对回溯算法不懂的，可能最不容易理解的就是最后一行，为什么要撤销选择。因为会出现分支污染问题，因为list是引用传递，
        //当从一个分支跳到另一个分支的时候，如果不把前一个分支的数据给移除掉，那么list就会把前一个分支的数据带到下一个分支去，造成结果错误。
        //走到底后的回溯到叶子结点的前一个结点，由于是root.left的回溯，直接执行dfs(root.right,target),向右走。
    }
    
} 

