package 从上到下打印二叉树III;
/* 
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
示例：

Copy
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
   
        q.add(root);
        boolean isoddrow = false;
        while (!q.isEmpty()) {
            isoddrow = !isoddrow;
            //生成一个双端队列
            LinkedList<Integer> temp = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                //如果是奇数层，需要从左往右显示，那么在插入链表（双向数组）时就要从尾部插入进来直达
                if (isoddrow) {
                    temp.addLast(node.val);
                    //如果时偶数层，需要从右往左显示，那么在插入时需要从链表首部插入
                }else{
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                //q 里装的是二叉树从上往下，从左往右的节点顺序。
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}