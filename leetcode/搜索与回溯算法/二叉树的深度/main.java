package 搜索与回溯算法.二叉树的深度;

import javax.swing.tree.TreeNode;

/* 
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
//递归思路
//分析问题自上而下，解决问题自下而上，递归递归，先递后归，
/* 
 * 
先定义一个函数，明确这个函数的功能，由于递归的特点是问题和子问题都会调用函数自身，所以这个函数的功能一旦确定了， 之后只要找寻问题与子问题的递归关系即可
接下来寻找问题与子问题间的关系（即递推公式），这样由于问题与子问题具有相同解决思路，只要子问题调用步骤 1 定义好的函数，问题即可解决。
所谓的关系最好能用一个公式表示出来，比如 f(n) = n * f(n-1) 这样，
如果暂时无法得出明确的公式，用伪代码表示也是可以的, 发现递推关系后，要寻找最终不可再分解的子问题的解，即（临界条件），确保子问题不会无限分解下去。
由于第一步我们已经定义了这个函数的功能，所以当问题拆分成子问题时，子问题可以调用步骤 1 定义的函数，符合递归的条件（函数里调用自身）
将第二步的递推公式用代码表示出来补充到步骤 1 定义的函数中
最后也是很关键的一步，根据问题与子问题的关系，推导出时间复杂度,如果发现递归时间复杂度不可接受，则需转换思路对其进行改造，看下是否有更靠谱的解法
 */
public class main {
    public int maxDepth(TreeNode root) {
        //如果一棵树只有一个结点，它的深度为1。
        /* 
    1
   /  \
  2    3
 / \    \
4  5     6
   /
   7
         * ①如果一棵树只有一个结点，它的深度为1。

　　②如果根结点只有左子树而没有右子树，那么树的深度应该是其左子树的深度加1；同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1。

　　③如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。

　　比如在上图的二叉树中，根结点为1的树有左右两个子树，其左右子树的根结点分别为结点2和3。根结点为2的左子树的深度为3，而根结点为3的右子树的深度为2，因此根结点为1的树的深度就是4。
         */
        if (root == null) {
            return 0;
        }
        //先递归左，在递归右，可能存在左右左的情况
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>=right ? left+1:right+1;//加上当前层的深度
    }
}
