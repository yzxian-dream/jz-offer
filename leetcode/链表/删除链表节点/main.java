/* 
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */

package 删除链表节点;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        //处理特殊情况
        if(head == null){
            return null;
        }
        //如果要删除的是头节点，直接返回后面的节点即可
        if(head.val == val){
            return head.next;
        }

        ListNode temp = head.next;
        ListNode pre = head;
        while(temp != null){
            if(temp.val == val){
                pre.next = temp.next;
                return head;
            }else{
                pre = pre.next;
                temp = temp.next;
            }
        }
        return head;
    }
}
