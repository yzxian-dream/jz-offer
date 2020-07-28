package main.java.com;
//1.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点保留一个即可，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2-3->4->5。在一个排序的链表中，

//2. 存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。

//第1题解法
/*public class Title56 {
    public ListNode deleteDuplication(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;//值相等断开连接，重连接到不等的节点上
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}*/

import java.util.List;

//第2题
//定义虚拟头节点pre，定义移动节点cur去查找重复节点
//没有重复的时候，pre与cur相隔一个节点，pre.next.next == cur;
//有重复的时候，cur需要连续移动，直到cur.val != cur.next.val，cur = cur.next；pre.next=cur；
// 这样就滤过（删除）重复值了
public class Title56 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode pre = res;
        ListNode cur = pHead;

        while(cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;//找到重复节点，一直后移
            }
            cur = cur.next;
            if (pre.next.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur;
            }
        }
        return res.next;


    }
        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }
    }
