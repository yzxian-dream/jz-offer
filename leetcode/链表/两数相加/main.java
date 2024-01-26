package 两数相加;

import 回文链表.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
 

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
[2,4,3]
l2 =
[5,6,4]
输出
[7,10,7]
预期结果
[7,0,8]


 */

 //注意这里的进位是向后进位，因为是逆序的
public class main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode dumyHead = new ListNode(0);
        ListNode newHead = dumyHead;
        int jinwei = 0;
        int curvalue = 0;
        while (h1 != null || h2 != null) {
            
            int valh1 = h1 == null?0:h1.val;
            int valh2 = h2 == null?0:h2.val;
            curvalue = (valh1+valh2+jinwei)%10;
            jinwei = (valh1+valh2)/10;
            ListNode next = new ListNode(curvalue);
            
            newHead.next = next;
            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }
            newHead = next;

        }
        if (jinwei == 1) {
            newHead.next = new ListNode(jinwei);
        }
        return dumyHead.next;
    }
}
