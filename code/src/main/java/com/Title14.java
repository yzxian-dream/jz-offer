package main.java.com;
//题目描述：
//
//  输入一个链表，输出该链表中倒数第k个结点。为了符合习惯，从1开始计数，
// 即链表的尾结点是倒数第1个节点。例如，一个链表有6个结点，从头结点开始，它们的值依次是1,2,3,4,5,6。
// 则这个链表倒数第三个结点是值为4的结点。
//方法一：快慢双指针
public class Title14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //思路：快慢指针，快指针先走k步，慢指针从头开始，都向前进，快指针到null时，前一个正好是倒数第k个
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) { //快指针先走k步，这样慢指针与快指针相隔k-1个，快指针走到底，
            // 慢指针正好在倒数第k个结点位置
            if (fast != null)
                fast = fast.next;
            else
                return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
