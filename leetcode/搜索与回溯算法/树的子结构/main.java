package 树的子结构;
//二叉树相关的题95%都是采用递归来做
/* https://www.iamshuaidi.com/272.html

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 1.首先固定A的头节点，判断B二叉树是不是以A的头节点为自己的头节点的子二叉树，如果不是
 * 递归判断一下B是不是以A的左节点为头节点的字树，或者判断一下B是不是以A的右节点为头节点的字树
 * 如果不是
 * 
 * 2.还需要定义一个函数isSubTree,用来判断1.
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        //从两颗树的头节点开始比，直到子树全部比完还没报错，说明子树B是A的子树
        //但是如果这个返回回来是false，也不代表B不是A的子树，而是需要从A的left节点或right节点再去递归比较
    
        if(isSubTree(A,B)){
            //具体的判断都在isSubTree里
            return true;
        }
        // if (isSubStructure(A.left,B)) {
        //     return ture;
        // }
        // if (isSubStructure(A.right,B)) {
        //     return ture;
        // }
        //一个或解决
        //递归调用的过程中，节点得在移动才能依次判断
        //这里对比对称二叉树，为什么对称二叉树不需要再调用这个当前方法递归，因为对称二叉树就是从头节点开始比较，通过下面的子方法已经递归到最底下，是就是，不是就不是，没有在需要换节点重新比价的情况，
        //这里判断子树，头节点不是，A的头节点的left和right可能和B能匹配上，所以需要递归当前方法。
        if (isSubStructure(A.right,B) || isSubStructure(A.left,B)){
            return true;
        }

        return false;
    }
    //递归三要素
    //首先明白这个函数是在做什么，这里就是在比对传的A节点和B节点是否相等
    //第二找到递归函数结束的条件，这里当然就是A节点值不等于B节点值。
    //第三要素：找出函数的等价关系式，这里就没用到
    boolean isSubTree(TreeNode A, TreeNode B){
        //判断B的节点是不是检查完了,能在这个函数里移动到最后的最后一个节点还没跳出去，说明满足条件，B是A的字树
        if (B == null) {
            return true;
        }
        //判断A的节点是不是检查完了,如果检查完了，B还有子节点，那么B一定不是A的子树。
        if (A == null) {
            return false;
        }
        //if里面一般用的都是极个别特殊情况，你就是不满足输出条件的，需要单领出来判断的这种情况的
        if (A.val != B.val) {
            return false;
        }
        return isSubTree(A.left,B.left) || isSubTree(A.right,B.right);


    }
}
