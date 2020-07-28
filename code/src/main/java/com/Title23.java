package main.java.com;
/*题目描述：二叉搜索树的后续遍历

  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。
 对于后续遍历序列，序列的最后一个值一定是树的根结点，而由二叉搜索树的性质：左小右大，我们可以从头开始遍历，
当遍历到某个值比根结点大时停止，记为flag，此时flag之前的所有数值都是二叉搜索树的左子树的结点，
flag以及flag之后的所有数都是二叉搜索树的右子树的结点。这是由二叉搜索树以及后序遍历共同决定的。

  接下来，我们就可以把任务交给递归，同样的方法去判断左子树和右子树是否是二叉搜索树，这显然是典型的递归解法。*/
public class Title23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int begin, int end) {
        if (end <= begin) //结束条件
            return true;
        //end为根节点，找左右子树的分界
        int i = begin;
        for (; i < end; i++) //找边界，并同时判断了左子树都小于根
            if (sequence[i] > sequence[end])
                break;
        for (int j = i + 1; j < end; j++) //右子树如果存在小于根的，则不是二叉搜索树
            if (sequence[j] < sequence[end])
                return false;
        return VerifySquenceOfBST(sequence, begin, i - 1) && VerifySquenceOfBST(sequence, i, end - 1);
    }
}