package 删除链表的倒数第n个节点;
/* 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
输入：head = [1,2], n = 2
输出：[2]
 */
public class main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                //说明n已经达到链表的长度，这样的话倒数第n个节点就是head；
                return head.next;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
