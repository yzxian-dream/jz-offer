package 搜索与回溯算法.二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import javafx.scene.Node;

/* 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，
 * 只能调整树中节点指针的指向。

 

为了让您更好地理解问题，以下面的二叉搜索树为例：
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        inorder(root,q);
        Node head = q.poll();
        Node pre = head;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inorder(Node root, Queue q) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        // stack.add(root);
        Node cur = root;
        //注意这里是｜｜
        while (!stack.isEmpty() || cur != null) {
            while (cur!=null) {
                // q.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            q.add(cur);
            cur = cur.right;

        }
        // inorder(root.left, q);
        // q.add(root);
        // inorder(root.right, q);
    }
}
