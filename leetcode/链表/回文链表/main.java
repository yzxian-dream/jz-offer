package 回文链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import 链表.两个链表的第一个公共节点.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

 

示例 1：


输入：head = [1,2,2,1]
输出：true

示例 2：


输入：head = [1,2,1]
输出：true

示例 3：


输入：head = [1,2]
输出：false
 

提示：

链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9

算法

 */
//借助stack 实现

// public class main {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null) {
//             return true;
//         }
//         Stack<ListNode> stack = new Stack<>();
//         ListNode cur = head;
//         while (cur != null) {
//             stack.push(cur);
//             cur = cur.next;
//         }

//         while (head != null && !stack.isEmpty()) {
//             if (head.val != stack.pop().val) {
//                 return false;
//             }
//             head = head.next;
//         }
//         return true;
//     }
    
// }


//方法2
/**
 * 复制链表值到数组列表中。
   使用双指针法判断是否为回文。
   时间复杂度O(n),空间复杂度O(n);
 */

// public class main {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null) {
//             return true;
//         }
//         List<ListNode> list = new ArrayList<>();
//         ListNode cur = head;
//         while (cur != null) {
//             list.add(cur);
//             cur = cur.next;
//         }

//         int l = 0;
//         int r = list.size()-1;
//         while (l<=r) {
//             if (list.get(l) != list.get(r)) {
//                 return false;
//             }
//             l++;
//             r--;
            
//         }
//         return true;
//     }
// }

/**
 * 
整个流程可以分为以下五个步骤：

找到前半部分链表的尾节点（通过快慢指针进行找，快指针每次走两步，慢指针每次走一次，当快指针走低到底，慢指针就只向了中间节点）。
反转后半部分链表。
判断是否回文。
恢复链表。
返回结果。
时间复杂度O(n),空间复杂度O(1);
 */

public class main {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode endOfFirstHalfNode = endOfFirstHalf(head);//左半部分最后一个node
        ListNode startSencondHalfNode = endOfFirstHalfNode.next;//右半部分第一个node

        ListNode p1 = endOfFirstHalfNode;
        ListNode p2 = reverseList(startSencondHalfNode);

        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        endOfFirstHalfNode.next = reverseList(startSencondHalfNode);
        return true;
    }

    public ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head; 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //左半部分最后一个
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}