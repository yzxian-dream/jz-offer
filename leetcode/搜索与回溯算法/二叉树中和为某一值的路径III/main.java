package 二叉树中和为某一值的路径III;

import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 

示例 1：



输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
 

提示:

二叉树的节点个数的范围是 [0,1000]
-109 <= Node.val <= 109 
-1000 <= targetSum <= 1000 
 */
// public class main {
//     public int pathSum(TreeNode root, int targetSum) {
//         if (root == null) {
//             return 0;
//         }

//         int ret = rootSum(root, targetSum);
//         ret += pathSum(root.left, targetSum);
//         ret += pathSum(root.right, targetSum);
//         return ret;
//     }

//     public int rootSum(TreeNode root, int targetSum) {
//         int ret = 0;

//         if (root == null) {
//             return 0;
//         }
//         int val = root.val;
//         if (val == targetSum) {
//             ret++;
//         } 

//         ret += rootSum(root.left, targetSum - val);
//         ret += rootSum(root.right, targetSum - val);
//         return ret;
//     }
// }

//换成long,防止越界
class main{
public int pathSum(TreeNode root, long targetSum) {
    if (root == null) {
        return 0;
    }
    long target = (long)targetSum;
    int ret = rootSum(root, target);
    ret += pathSum(root.left, (int)targetSum);
    ret += pathSum(root.right, (int)targetSum);
    return ret;
}

public int rootSum(TreeNode root, long targetSum) {
    int ret = 0;

    if (root == null) {
        return 0;
    }
    long val = (long) root.val;
    if (val == targetSum) {
        ret++;
    } 

    ret += rootSum(root.left, targetSum - val);
    ret += rootSum(root.right, targetSum - val);
    return ret;
}
}
