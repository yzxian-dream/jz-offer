package 反转链表;
//递归 ,空间复杂度O(n)
// public class main {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode temp = reverseList(head.next);
//         head.next.next = head;
//         head.next = null;
//         return head;
//     }

// }


//双指针，原地排序 空间复杂度O(1)
public class main {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        listNode pre = null,cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}