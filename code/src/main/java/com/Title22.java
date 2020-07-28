package main.java.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*题目描述：

  从上往下打印出二叉树的每个节点，同层节点从左至右打印。

  解题思路：

  本题实际上就是二叉树的层次遍历，深度遍历可以用递归或者栈，而层次遍历很明显应该使用队列。
同样我们可以通过一个例子来分析得到规律：每次打印一个结点时，如果该结点有子结点，则将子结点放到队列的末尾，
接下来取出队列的头重复前面的打印动作，直到队列中所有的结点都打印完毕。*/
public class Title22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //思路：使用队列来实现
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue=new LinkedList<>(); //定义一个队列
        queue.add(root);
        while(queue.size()!=0){
            TreeNode temp=queue.poll();//队头移除
            res.add(temp.val);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return res;
    }
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
}
