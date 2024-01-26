package 二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

 //方法1 递归,面试不用
// class Solution {
//     List<Integer> ret = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         if (root == null) {
//             return ret;
//         }
//         ret.add(root.val);
//         preorderTraversal(root.left);
//         preorderTraversal(root.right);
//         return ret;
//     }
// }

//DFS 深度优先遍历
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ret;
        }
        TreeNode cur = root;
//注意这里stack判断空的方式
//stack和queue都是isEmpty()方法
//链表都是！=null 来判断
        while(cur != null || !stack.isEmpty()){
            //前序遍历，处理完root节点后，在处理左子节点
            while (cur != null) {
                ret.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;

        }
        return ret;
    }
}