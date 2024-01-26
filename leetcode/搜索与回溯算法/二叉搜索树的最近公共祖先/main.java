package 搜索与回溯算法.二叉搜索树的最近公共祖先;

import javax.swing.tree.TreeNode;
/* 
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]



 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
//先对二叉树进行分析
/* 
 * 1. 当前节点是空节点 返回当前节点 return root
 * 2. 当前节点是p  return root
 * 3. 当前节点是q  return root
 * 4. 其他：是否找到p或q
 *   - 左右子树都找到  return root
 *   - 只有左子树找到  那么最近公共祖先肯定在左子树中，返回递归左子树的结果
 *   - 只有右子树找到  那么最近公共祖先肯定在右子树中，返回递归右子树的结果
 *   - 左右子树都没找到  return null
 */
// public class main {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null || root == p || root == q) {
//             return root;
//         }
//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);
           // 左右子树都找到
//         if (left != null && right != null) {
//             return root;
//         }

//         if (left != null) {
//             return left;
//         }
//         return right;
//     }
// }

//对于二叉搜索树的特点，左子树的值都小于根结点，右子树的值都大于根结点

public class main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int x = root.val;
        if (q.val < x && p.val < x) {
            //都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if (q.val > x && p.val > x) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //如果分别在两边则最近公共节点肯定是root
        return root;
    }
}