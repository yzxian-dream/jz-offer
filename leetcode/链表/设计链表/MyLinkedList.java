package 设计链表;
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList(){
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode phead = head;
        for (int i = 0; i <= index; i++) {
            phead = phead.next;
        }
        return phead.val;

    }
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    public void addAtTail(int val){
        addAtIndex(size, val);
    }
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode phead = head;
        for (int i = 0; i < index; i++) {
            phead = phead.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = phead.next;
        phead.next = newNode;
    }
    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // ListNode phead = head;
        if (index == 0) {
            head = head.next;
            return;
        }
       
        ListNode phead = head;
        for (int i = 0; i < index; i++) {
            phead = phead.next;    
        }
        phead.next = phead.next.next;
    }
    
}
