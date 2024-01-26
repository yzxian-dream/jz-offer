package 链表中倒数第k个节点;

/* 
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//暴力法
// class Solution {
//     public ListNode getKthFromEnd(ListNode head, int k) {
//         if (head == null) {
//             return head;
//         }
//         int count = 0;
//         ListNode cur = head;
//         while (head != null) {
//             count++;
//             head = head.next;
//         }
//         while (cur != null) {
//             if (count == k) {
//                 return cur;
//             }
//             count--;
//             cur = cur.next;
//         }
//         return cur;
//     }
// }


/* 
 * class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)   return null;
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        cur=head;
        while(size-k>0){
            cur=cur.next;
            size--;
        }
        return cur;


    }
}
 */

//快慢指针
/* 
 * 思路二（双指针）：
1.设置双指针slow和fast，使其都在head处
2.让fast先走k步
3.让slow和fast同时向后一步一步走，直至fast为空
4.slow所处的位置就是倒数第K个节点
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
