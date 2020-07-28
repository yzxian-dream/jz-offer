package main.java.com;

import java.util.*;

/*
* 题目描述：层序遍历

  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

  解题思路：

  本题可类比第22题：从上往下打印二叉树，这两道题实际上是一回事，只不过这里我们多了一个分行打印的要求，
* 实际上大同小异，稍加修改即可。

  在二叉树层次遍历上，我们使用的是队列，借助队列先进先出的性质实现，具体规律：每次打印一个结点时，
* 如果该结点有子结点，则将子结点放到队列的末尾，接下来取出队列的头重复前面的打印动作，直到队列中所有的结点都打印完毕。
* 在此基础上我们考虑这里的分行要求，不难想到我们只要增加两个变量即可：一个用于保存当前层中还没有打印的结点个数，
* 另一个用于记录下一层结点的数目。而使用队列的话，实际上这两个变量可以统一用队列的长度来实现。*/
public class Title60 {
    //ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        if (pRoot == null){
            return list1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int len = queue.size();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                pRoot = queue.poll();
                list2.add(pRoot.val);
                if (pRoot.left != null){
                    queue.offer(pRoot.left);
                }
                if (pRoot.right != null){
                    queue.add(pRoot.right);
                }
            }
            list1.add(list2);
        }
        return list1;
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
