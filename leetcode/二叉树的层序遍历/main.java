package 二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
// class Solution {
//     public List<Integer> levelOrder(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         List<Integer> list = new ArrayList<>();
//         TreeNode cur = root;
//         q.add(cur);
//         while (!q.isEmpty()) {
//             TreeNode node = q.remove();
//             list.add(node.val);
//             if (node.left != null) {
//                 q.add(node.left)
//             }
//             if (node.right != null) {
//                 q.add(node.right)
//             }
//         }
//     }
// }

//保存每层的结果

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelresult = new LinkedList<>();
            int n = q.size();//这里一定要把q.size()提前赋值给变量，否则for循环的过程中，队列逐步减小，q.size也在减小
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                levelresult.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(levelresult);
            
        }
        return res;
    }
}

