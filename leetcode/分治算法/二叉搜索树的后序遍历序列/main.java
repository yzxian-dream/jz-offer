package 分治算法.二叉搜索树的后序遍历序列;
/* 
 * 请实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。

 

示例 1：



输入: postorder = [4,9,6,5,8]
输出: false 
解释：从上图可以看出这不是一颗二叉搜索树
示例 2：



输入: postorder = [4,6,5,9,8]
输出: true 
解释：可构建的二叉搜索树如上图
 

提示：

数组长度 <= 1000
postorder 中无重复数字
 */
//二叉搜索树的特点是根节点>左子节点，根节点<右子节点
public class main {
    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder == null) {
            return true;
        }
        return f(postorder,0,postorder.length-1);
    }
    public boolean f(int[] postorder,int i,int j){
        //终止条件： 当 i≥ji \geq ji≥j ，说明此子树节点数量 ≤1\leq 1≤1 ，无需判别正确性，因此直接返回 true\text{true}true ；
        if (i >= j) {
            return true;
        }
        //找到根节点
        int root = postorder[j];
        int p = i;
        //找到第一个大于根节点的值，则可以区分出左子树和右子树
        while (postorder[p]<root) {
            p++;
        }
        //在右子树（理论上应该都大于根节点）中是否能找出小于根节点的值，能找到他就不是合格的后续遍历二叉搜索树
        for (int k = p; k < j; k++) {
            if (postorder[k]<root) {
                return false;
            }
        }
        return f(postorder, i,p-1) && f(postorder, p, j-1);
        
    }
}
