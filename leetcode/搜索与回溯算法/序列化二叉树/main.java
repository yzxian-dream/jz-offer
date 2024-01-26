package 搜索与回溯算法.序列化二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/* 
 * 请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]


 */
//把层序遍历到结果反序列化成一个二叉树，但是不同的是，这里未来知道某个节点的左右子节点情况，即使左或右节点为null，也要保存下来
public class main {
    public String serialize(TreeNode root){
        //序列化成字符串 1，2，3,null,null,4,5...
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        TreeNode cur = root;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // sb.add(node.val);
            if (node != null) {
                q.add(node.left);
                q.add(node.right);
                sb.append(node.val+",");//拼接节点成字符串
            }else{
                sb.append("null,"); // 这里的，别忘了加
            }
            
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data){
        //1，2，3,null,null,4,5... 
        if (data == null || data.length() <= 0) {
            return null;
        }
        String[] s = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root  = new TreeNode(Integer.parseInt(s[0]));//获取头节点
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            //构建左子节点
            if (!s[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                node.left = left;
                q.add(left);
            }else{
                node.left = null; //这一步可以省略，因为新建的节点的默认左右就是null
            }
            i++;
            //构建右子节点
            if (!s[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                node.right = right;
                q.add(right);
            }else{
                node.right = null;
            }
            i++;
        }
        return root;
    }
}
