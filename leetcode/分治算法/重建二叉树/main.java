package 分治算法.重建二叉树;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;
/* 
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

示例 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

限制：

0 <= 节点个数 <= 5000
 */
public class main {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = f(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
        return root;
    }
    //根据前序遍历找到跟节点，在在中序遍历中找到跟节点的下标位置，区分出左子节点和右子节点个数，按此规律以此往下找，就是化成了子问题进行处理，递归解决。
    private TreeNode f(int l1, int r1, int[] preorder, int l2, int r2, int[] inorder) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int i = map.get(preorder[l1]);
        // 递归地构造左子树，并连接到根节点,i-l2时左节点个数。
        root.left =  f(l1+1, l1+(i-l2), preorder, l2, i-1, inorder);
        // 递归地构造右子树，并连接到根节点
        root.right = f(l1+1+(i-l2), r1, preorder, i+1, r2, inorder);
        return root;
    }
}
