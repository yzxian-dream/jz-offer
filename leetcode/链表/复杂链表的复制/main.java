package 复杂链表的复制;

import javafx.scene.Node;

/*

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/* 
 * 链表里输入的头节点header 他后面是通过next一个连一个的，比如1->2->3->4,输入头节点到func（header,
 * 后面一番操作链表顺序打乱后，假如变成3—>2->1->4,这个时候输入进来的原始header val没变还是1，不过
 * 他的指针方向变了，也就是header.next = 4,而不是刚开始的2.
 */

class Solution {
    public Node copyRandomList(Node head) {
      if (head == null) {
          return head;
      }
      //复制链表节点  A->B->C----->(A-A1->B->B1->C-C1)
      Node cur = head;
      while (cur != null) {
          Node temp = cur.next; //为了在修改当前节点顺序指向前把该节点的下一个节点保存下来，一遍后面使用，用来挨个往后移动是替换当前节点
          Node newCur = new Node(cur.val);
          cur.next = newCur;
          cur.next.next = temp;//newcur.next = temp
          cur = temp;   //这里注意。链表节点的指针指向改变后，一般是要顺序往后移动，循环操作，打到目的，养成这个思维模式，当前节点指向改变，最后一步就是要把后一个节点赋值给他
      }

      //复制随机节点
      cur = head;
      while (cur != null) {
          cur.next.random = cur.random == null ? null : cur.random.next;
          cur = cur.next.next;
      }
      //拆分链表A-A1->B->B1->C-C1,拆成（A->B->C）和（A1->B1->C1）
      Node newHeader = head.next;
      cur = head;
      Node curHeader = head.next;
      while (cur != null) {
          cur.next = cur.next.next;
          cur = cur.next;
          curHeader.next = cur == null ? null : cur.next;
          curHeader = curHeader.next;
      }
      return newHeader; //复制的链表从A1开始
  }
}
