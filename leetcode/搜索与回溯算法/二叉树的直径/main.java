package 二叉树的直径;

import javax.swing.tree.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。

 

示例 1：


输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
示例 2：

输入：root = [1,2]
输出：1
 

提示：

树中节点数目在范围 [1, 104] 内
-100 <= Node.val <= 100
 */

 /**
  * 方法一：深度优先搜索
首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。

而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。

  */
public class main {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res-1;
        
    }
    public int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        res = Math.max(res,l+r+1);
        return Math(l,r)+1;
    }
}
