package 排序链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import 回文链表.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

 

示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]
 

提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105
 

进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
//可以转换成数组来排序在转成新的链表

public class main {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur=cur.next;
        }
        list.sort(new Comparator<ListNode>() {
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val
            }
            
        });

        for (int i = 0; i < list.size(); i++) {
            list.get(i).next = list.get(i+1);
        }
        list.get(list.size()-1).next = null;
        return list.get(0);
    }
}



//也可以自定向下的递归实现，归并排序，递归的终止条件与数组类似，头节点和尾节点相遇，递归的终止条件是链表的节点个数小于或等于 1，即当链表为空或者链表只包含1个节点时，不需要对链表进行拆分和排序
public class main {
    public ListNode sortList(ListNode head) {

        return mergeSort(head,null);
    }
    public ListNode mergeSort(ListNode head,ListNode tail){
        if(head == null){
            return head;
        }

        if(head.next == tail){
            head.next = null; //这种首尾就两个节点，打断链表
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
            
        }


        ListNode mid = slow;
        ListNode list1 = mergeSort(head,mid);
        ListNode list2 = mergeSort(mid,tail);
        return merge(list1, list2);
    
    } 

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
