package main.java.com;
//反转链表
//题目描述
//输入一个链表，反转链表后，输出新链表的表头。
//思路一
//定义两个节点，向后移动并改变逆转指向
/*public class Title15 {
    public ListNode ReverseList(ListNode head) {
        if(head.next == null || head == null){
            return head;
    }
        ListNode frontNode = head;//定义指针1
        ListNode removeNode = head.next;//定义移动指针2
        while (removeNode != null){
            ListNode tempNode = removeNode.next;//临时节点，存放下一个节点以防连接断开，指针无法找到下个节点没法向前移动
            removeNode.next = frontNode;
            frontNode = removeNode;//向后移动一个节点
            removeNode = tempNode;//向后移动一个节点
        }
        head.next = null;//1-->2还没有断开，要断开让1-->null
        return frontNode;
}
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}*/
//思路二：和思路一差不多，只是在开头直接断开头节点和下一个节点的连接

public class Title15 {
    public ListNode ReverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
        return head;
    }
    ListNode pre = null; // 当前节点的前一个节点
    ListNode next = null; // 当前节点的下一个节点
        while( head != null){
        next = head.next; // 记录当前节点的下一个节点位置；
        head.next = pre; // 让当前节点指向前一个节点位置，完成反转
        pre = head; // pre 往右走
        head = next;// 当前节点往右继续走
    }
        return pre;
}
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
