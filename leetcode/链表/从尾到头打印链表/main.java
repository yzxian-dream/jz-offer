package 从尾到头打印链表;

import java.util.Stack;
/* 
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 */
// class Solution {
//     public int[] reversePrint(ListNode head) {
//         Stack<ListNode> stack = new Stack<ListNode>();
//         ListNode temp = head;
//         while (temp != null) {
//             stack.push(temp);
//             temp = temp.next;
//         }
//         int size = stack.size();
//         int[] print = new int[size];
//         for (int i = 0; i < size; i++) {
//             print[i] = stack.pop().val;
//         }
//         return print;
//     }
// }

class Solution {
    public int[] reversePrint(ListNode head) {
          
        if(head == null){
            return new int[0];
        }
        ListNode pre = null;
        ListNode cur = head;
      
        int count = 0;
        while(cur != null){
            count++;
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        int[] a = new int[count];
        int i = 0;
        while(pre != null){
            a[i++] = pre.val;
            pre = pre.next;
        }
        return a;
    }
}