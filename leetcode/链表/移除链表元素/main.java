package 移除链表元素;

import 链表.两个链表的第一个公共节点.ListNode;

/* 
 * 题意：删除链表中等于给定值 val 的所有节点。

示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]

示例 2： 输入：head = [], val = 1 输出：[]

示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
链表中可能出现多个等于val的节点
#
 */
public class main {
//     public ListNode removeElements(ListNode head, int val) {
//         while (head != null && head.val == val) {
//             head = head.next;
//         }
//         if (head == null) {
//             return null;
//         }
//         ListNode pre = head;
//         ListNode cur = head.next;
//         while (cur != null) {
//             if (cur.val == val) {
//                 pre.next = cur.next;
//             }else{
//                 pre = cur;
//             }
//             cur = cur.next;
//         }
//         return head;
//     }
// }

//递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next:head;
    }
}