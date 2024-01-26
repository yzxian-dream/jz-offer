package 二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 

示例 1:



输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:

输入: [1,null,3]
输出: [1,3]
示例 3:

输入: []
输出: []
 

提示:

二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100 
 */
//这个代码首先检查根节点是否为空，如果为空则返回一个空的ArrayList。然后，创建一个队列并将根节点放入队列中。然后，进入一个循环，该循环会持续到队列为空。在每个循环中，
//它会检查当前层的所有节点，并将它们的子节点添加到队列中。每层的最后一个节点就是从右侧看到的节点，因此将其添加到结果列表中。这个函数返回的结果就是二叉树的右视图。
//  方法一：利用BFS(广度优先遍历)进行层序遍历，记录下每层的最后一个元素
//时间复杂度o(n),空间复杂度O(n)
// public class main {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode node = q.poll();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == size-1) {
                    list.add(node.val);
                }
            }
        }
        return list;
    }
// }
//方法二：DFS
/**
 * 
 * 
 * 思路： 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
（与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）

时间复杂度： O(N)，每个节点都访问了 1 次。
空间复杂度： O(N)，因为这不是一棵平衡二叉树，二叉树的深度最少是 logN, 最坏的情况下会退化成一条链表，深度就是 N，因此递归时使用的栈空间是 O(N) 的

 */
public class main {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root,int depth){
        if (root == null) {
            return;
        }
        //先访问当前节点，在递归的访问右子树和左子树
        //由于要取右视图，所以depth开始始终和最有节点数量保持一致，因为一层就只有一个最右节点，list add后，depth++，保持同步，后面递归左子树时，depth和list.size不匹配就装不进去了
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        //下面的depth时第一次递归时的大小，也就是1，而res已经走到底了有n个数
        dfs(root.left,depth);
        
    }
}

//一般使用bfs来做这道题
//地下这种非递归方法也就是迭代方法实现不了，depth无法控制，右视图并不是最右边所有节点，如果最右边没有节点，没挡住左边节点，那么左边节点也要入list.

// public class main {

//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode cur = root;
//         int depth = 0;
//         while (!stack.isEmpty() || cur != null) {
//             if(cur.right != null){
//                 depth = -1;
//             }
//             while (cur != null) {
//                 if (depth == res.size()) {
//                     res.add(cur.val);
//                 }
//                 depth++;
//                 stack.add(cur);
//                 cur = cur.right;
//             }
//             // depth = 0;
//             cur = stack.pop();
//             cur = cur.left;
//         }
//         return res;
//     }
// }