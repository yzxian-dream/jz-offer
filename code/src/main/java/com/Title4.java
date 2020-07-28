package main.java.com;
/*题目描述：重建二叉树

  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回根结点。

  解题思路：

  树的遍历有三种：分别是前序遍历、中序遍历、后序遍历。本题是根据前序和中序遍历序列重建二叉树，
我们可以通过一个具体的实例来发现规律，不难发现：前序遍历序列的第一个数字就是树的根结点。在中序遍历序列中，
可以扫描找到根结点的值，则左子树的结点都位于根结点的左边，右子树的结点都位于根结点的右边。

  这样，我们就通过这两个序列找到了树的根结点、左子树结点和右子树结点，接下来左右子树的构建可以进一步通过递归来实现。*/

public class Title4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length == 0){
            return null;
        }
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd){
            return null;
        }
        int rootValue = pre[preBegin];
        TreeNode root = new TreeNode(rootValue);
        int p1 = inBegin;
        while(inBegin < inEnd && in[p1] != rootValue){
            p1++;
        }
        int leftCount = p1 - inBegin;
        root.left=reConstructBinaryTree(pre,in,preBegin+1,preBegin+leftCount, inBegin,p1-1);
        root.right=reConstructBinaryTree(pre,in,preBegin+leftCount+1, preEnd,p1+1,inEnd);
        return root;
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

