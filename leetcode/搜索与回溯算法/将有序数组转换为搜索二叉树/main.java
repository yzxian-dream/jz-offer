package 将有序数组转换为搜索二叉树;

import javax.swing.tree.TreeNode;
/**
 * 二叉树的中序遍历是升序遍历，所以nums就是二叉搜索树的中序遍历
 */
public class main {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length-1);

    }
    public TreeNode helper(int nums[],int l, int r){
        if (l < r) {
            return null;
        }
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid-1);
        root.right = helper(nums, mid+1, r);
        return root;
    }
}
