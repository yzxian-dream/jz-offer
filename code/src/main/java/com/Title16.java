package main.java.com;
//题目描述：
//
//  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
//
//  解题思路：
//
//  首先需要判断几个特殊情况，即判断输入的两个指针是否为空。如果第一个链表为空，
// 则直接返回第二个链表；如果第二个链表为空，则直接返回第一个链表。
// 如果两个链表都是空链表，合并的结果是得到一个空链表。
//两个链表都是排序好的，我们只需要从头遍历链表，判断当前指针，
// 哪个链表中的值小，即赋给合并链表指针，剩余的结点仍然是排序的，
// 所以合并的步骤和之前是一样的，所以这是典型的递归过程，用递归可以轻松实现。
//方法一：非递归
/*
public class Title16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
       if (list1 == null){
           return list2;
       }else if (list2 == null){
           return  list1;
       }
       ListNode headNode;
       if (list1.val < list2.val){
           headNode = list1;
           list1 = list1.next;
       }else if (list1.val > list2.val){
           headNode = list2;
           list2 = list2.next;
       }
       ListNode removeNode = headNode;
       while (list1 != null && list2 != null){
           if (list1.val < list2.val){
               removeNode.next = list1;

               list1 = list1.next;
           }else if (list1.val > list2.val){
               removeNode.next = list2;

               list2 = list2.next;
           }
           removeNode = removeNode.next;
       }
       while (list1 != null){
           removeNode.next = list1;
           removeNode = list1;
           list1 = list1.next;
       }
        while (list2 != null){
            removeNode.next = list2;
            removeNode = list2;
            list2 = list2.next;
        }
        return headNode;

       
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
*/
public class Title16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);//链表的构造函数，生成ListNode链表对象，链表的值为0，没有指向的节点
        ListNode cur = res;//尾插法
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        } else if (list2 != null) {
            cur.next = list2;
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