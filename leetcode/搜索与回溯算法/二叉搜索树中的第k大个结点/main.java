package 搜索与回溯算法.二叉搜索树中的第k大个结点;

import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/* 
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 

限制：

1 ≤ k ≤ 二叉搜索树元素个数

倒着数的第k个元素，是顺着数的第n - k + 1个元素，n表示元素总个数,原因是共n个数，
那么倒数第k个前面还有n - k个元素，则顺着数应该是n - k + 1,又因为下标是从0开始的，故第n - k + 1个元素的下标是n - k
 */
// public class main {
//     int k;
//     int target = 0;
//     public int kthLargest(TreeNode root, int k) {
//         this.k = k;
//         order(root);
//         return target;

//     }
//     //二叉搜索树的中序遍历左根右就是从小到大排序
//     //右根左就是从大到小排序
//     void order(TreeNode root) {
//         if (root == null || k<0) {
//             return;
//         }
      
//         order(root.right);
//         k--;
//         if (k == 0) {
//             target = root.val;
//         }
//         order(root.left);
//     }
// }


//小顶堆做法
/* 
 * 由于题目中给定的二叉搜索树，所以可以直接中序遍历然后拿到倒数第k个元素即可。但如果给定的是一棵普通的树呢？
 * 那么没有了中序遍历后便是有序列表的性质，我们就不能用解法一了，故这里再介绍一个更通用的解法，使用小顶堆。

无论用前序、中序、后序遍历都行，能遍历完树的所有节点就可以。为了和解法一统一，我们这里也选中序遍历。

遍历到当前节点时，直接加入小顶堆，但当堆中的元素大于k个时，就弹出堆顶元素，即让堆中最多保留k个元素，
那么遍历结束后，堆中就剩下k个元素，且堆顶的就是我们要的第k大的元素。
小顶堆默认的出队顺序从小往大出队，留在队里的时大到小。
 */

 /**
  * 
  堆是一种非线性结构，可以把堆看作一棵二叉树，也可以看作一个数组，即：堆就是利用完全二叉树的结构来维护的一维数组。
堆可以分为大顶堆和小顶堆。
大顶堆：每个结点的值都大于或等于其左右孩子结点的值。
小顶堆：每个结点的值都小于或等于其左右孩子结点的值。
如果是排序，求升序用大顶堆，求降序用小顶堆。
一般我们说 topK 问题，就可以用大顶堆或小顶堆来实现，
最大的 K 个：小顶堆
最小的 K 个：大顶堆

PriorityQueue默认是一个小顶堆
大顶堆：
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
    public int compare(Integer o1,Integer o2){
        return o2-o1;
        // return o2.compareTo(o1);
    }
})
  */

 public class main {
    int k;
    int target = 0;
    public int kthLargest(TreeNode root, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        inorder(root, q, k);
        return q.peek(); //peek出来的是当前小顶堆堆最小值。

    }
    public void inorder(TreeNode root, Queue<Integer> q,int k){
        if(root == null){
            return;
        }
        inorder(root.left, q, k);
        q.offer(root.val);
        if (q.size() > k) {
            q.poll();//poll掉的也是当前小顶堆堆最小值。，因为它默认poll掉的是相对小的值，那么一趟遍历走下来，保留的就是相对大的k个数字了
        }
        inorder(root.right, q, k);
    }
}

//求第k小如下。

// public int kthSmallest(TreeNode root, int k) {
//     Queue<Integer> q = new PriorityQueue<>((x,y)->(y-x));
//     inorder(root, q, k);
//     return q.peek();

// }
// public void inorder(TreeNode root,Queue<Integer> q,int k){
//     if (root == null) {
//         return;
//     }
//     inorder(root.left, q, k);
//     q.offer(root.val);
//     if (q.size()>k) {
//         q.poll();
//     }
//     inorder(root.right, q, k);
// }