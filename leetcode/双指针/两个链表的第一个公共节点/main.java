package 两个链表的第一个公共节点;
/* 
 * 输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：



在节点 c1 开始相交。

 

示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 

示例 2：



输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，
链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 */

//思路一，计算出两个链表的长度a，b，长的链表先走a-b步,此时两个指针距离两个链表的尾节点距离相等，直接对比当前指针对应的节点值，相等即为公共节点
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int alength = getLinkLengthListNode(headA);
        int blength = getLinkLengthListNode(headB);
        int diff = Math.abs(alength-blength);
        ListNode curA ;
        ListNode curB ;
        if (blength > alength) {
            curA = headA;
            curB = headB;
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
        }else{
            curA = headA;
            curB = headB;
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
        }
        
        while (curA != null && curB != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;

    }

    int getLinkLengthListNode(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

// //思路二，从自己的头部往对方走，知道遇到相同的节点返回
// class Solution {
//     ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if(headA == null || headB == null){
//             return null;
//         }
//         ListNode curA = headA;
//         ListNode curB = headB;
//         while(curA != curB){
//             curA.next = curA.next == null ? headA : curA.next;
//             curB.next = curB.next == null ? headB : curB.next;
//         }
//         return curA;
//     }
// }
