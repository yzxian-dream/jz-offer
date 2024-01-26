package 二叉树展开为链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 

示例 1：


输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]
 

提示：

树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100
 

进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */

 //先前序遍历，在按要求转换为二叉树
// public class main {
//     public void flatten(TreeNode root) {
//         List<TreeNode> list = new ArrayList<>();
//         preorder(list, root);
//         int size = list.size();
//         for (int i = 1; i < size; i++) {
//             TreeNode pre = list.get(i-1);
//             pre.left = null;
//             pre.right = list.get(i);
//         }

//     }
//     public void preorder(List<TreeNode> list,TreeNode root){
//         if (root == null) {
//             return;
//         }
//         list.add(root);
//         preorder(list, root.left);
//         preorder(list, root.right);
//     }
// }

public class main {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        for (int i = 1; i < list.size() i++) {
            TreeNode pre = list.get(i-1);
            pre.left = null;
            pre.right = list.get(i);
        }
    }
}
