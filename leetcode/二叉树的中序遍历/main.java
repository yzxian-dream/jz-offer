import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
//非递归实现，使用一个栈(由于要先遍历左孩子，所以要从根节点不断向左移动，直到没有左孩子的节点，把他加入结果，但是途径的这些节点在左孩子遍历之后还需要在读取
//所以需要在移动的过程中记录下来，由于读取过程是从下到上的，而记录过程是从上到下的，所以符合栈的性质，
//思路：整体的遍历过程就是不断向左孩子移动，，总是把当前节点入站，直到空节点，把栈顶元素弹出，并加入结果，然后看栈顶元素的右孩子，把当前节点设置为右孩子，重复这个过程。
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            //首先从当前节点向左孩子出发，不断把非空节点入站
            //用栈记录从上到下的左孩子
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            //把当前节点设置为右孩子，继续重复这个过程
            cur = cur.right;

        }
        return list;
    }
}