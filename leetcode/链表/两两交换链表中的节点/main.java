package 两两交换链表中的节点;
/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

 

示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100

[1,2,3]

添加到测试用例
输出
[2,1]
预期结果
[2,1,3]
 */
// public class ListNode {
//     int val;
//     ListNode next;
//     public ListNode(int val){
//         this.val = val;
//         this.next = null;
//     }
    
// }
// public class main {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode dumyNode = new ListNode(0);
//         ListNode newHead = dumyNode;
//         // dumyNode.next = head;
//         ListNode cur = head;
        
//         while (cur != null) {
//             // if(cur.next != null){
//             //     newHead.next = cur;
//             // }
//             ListNode temp = cur.next == null ? null:cur.next.next;//3
//             ListNode newNode = reverse(cur);//2-->1
//             // if (temp != null && temp.next == null) {
//             //     newHead.next.next = temp;
//             // }
//             newHead.next = newNode;//0-->2-->1
//             cur = temp;//3
//             newHead = newNode.next;
            

//         }
//         return dumyNode.next;

//     }
//     public ListNode reverse(ListNode head){
//         ListNode pre = null;
//         ListNode cur = head;
//         if (head.next == null) {
//             return head;
//         }
//         for (int i = 0; i < 2; i++) {
//             ListNode temp = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = temp;
//         }
//         return pre;
//     }
// }


/**
 *递归和迭代都是循环的一种。 简单地说，递归是重复调用函数自身实现循环。 
 迭代是函数内某段代码实现循环，而迭代与普通循环的区别是：循环代码中参与运算的变量同时是保存结果的变量，
 当前保存的结果作为下一次循环计算的初始值。 递归循环中，遇到满足终止条件的情况时逐层返回来结束。 
 */

//方法2
//上面是自己的迭代方法ok
//这里采用递归实现

// public class main {
//     public ListNode swapPairs(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode newHead = head.next;
//         //在这里递归走会一直都到最后一个
//         head.next = swapPairs(newHead.next);
//         //当上面第一次返回的时候，此时head已经是最后的值了，比如[1,2,3,4],第一次返回时这里的head是3不是1，
//         //有最后一点一点收涑回来，眼前的问题取决于远端的某个问题，当最远端的某个问题解决了，相关答案一路return收涑回眼前这个问题，眼前的问题随之解决。
//         newHead.next = head;
//         return newHead;
//     }
    
// }
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumyNode = new ListNode(0);
        dumyNode.next = head;
        ListNode temp = dumyNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dumyNode.next;
    }
}

//迭代
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode dummyHead = new ListNode(0);
//         dummyHead.next = head;
//         ListNode temp = dummyHead;
//         while (temp.next != null && temp.next.next != null) {
//             ListNode node1 = temp.next;
//             ListNode node2 = temp.next.next;
//             temp.next = node2;
//             node1.next = node2.next;
//             node2.next = node1;
//             temp = node1;
//         }
//         return dummyHead.next;
//     }
// }



