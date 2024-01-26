package 反转链表II;
/* 
 * 输入： head = [1,2,3,4,5], left = 2, right = 4
输出： [1,4,3,2,5]

示例 2：

输入： head = [5], left = 1, right = 1
输出： [5]

提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

 */

import 链表.两个链表的第一个公共节点.ListNode;

/* 
  * 解法一：迭代法
与206. 反转链表题目类似，本题的核心还是在反转链表，只不过这里不是从头开始反转，而是从指定位置反转。
既然不是从头开始反转，那我们就找到开始反转链表的位置，接着调用反转链表的方法完成链表的反转。
需要注意的是，为了标识需要反转的结束位置，我将right-left传入方法中，循环时不断自减k来标识反转的边界。
在循环中还需要做的是，需要将新的尾结点的next指针指向原先尾节点的next指针，这样可以避免再次遍历一次链表。
  */
// public class main {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         //和反转链表I不相同的地方是，先找出需要反转的链表头节点和个数
//         //定义虚拟节点
//         if (head == null) {
//             return null;
//         }
//         ListNode dumyNode = new ListNode(0);
//         dumyNode.next = head;
//         // ListNode now = dumyNode,pre = dumyNode;
//         // for (int i = 0; i < left; i++) {
//         //     pre = now;
//         //     now = now.next;
//         // }
//         ListNode pre = dumyNode,now = dumyNode.next;
//         for (int i = 0; i < left-1; i++) {
//             pre = pre.next;
//             now = now.next;
//         }
//         //此时now就是要反转部分的链表的头节点，而pre就是要接反转后新的头节点的节点
//         //比如例子1-2-3-4-5，现在pre就是1，now是2；
//         //将链表2-3-4-5传入进行
//         pre.next = reverse(now, right-left);//1--->4--->3--->2--->5
//         return dumyNode.next;

//     }
//     public ListNode reverse(ListNode head,int k){
//         ListNode pre = null;
//         ListNode cur = head;
//         //用k来控制需要反转的个数
//         while (k >= 0) {
//             ListNode temp = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = temp;
//             k--;
//         }
//         //这个时候head 是该链表反转后的最后一个链表，cur是后一个节点，要把他们接上
//         head.next = cur; // head是2，cur是, 2--->5
//         return pre; //pre是4
//     }

// }
//方法二 穿针引线 头插法
/* 
 * 根据题意，我们需要反转从节点2开始的链表，所以我们可以知道，2节点一定是最后一个节点，
 * 而所谓的反转就是不断将后面的节点依次插入到2节点前面。
以上的思路也可以叫做头插法，就是将后面的节点插入到新链表的头节点中。
这种穿针引线方法的节点赋值的顺序十分重要，通过我们设置的两个指针p，q可以分别指向新子链表的前驱节点和新链表的最后一个节点。
在修改removed待移动节点的next指针时，并不是将next指针指向q，因为后续removed和q之间可能会新增其他节点。ps，因为这是头插法，这是十分容易出错的一个点。
 */
public class main {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dumyNode = new ListNode(0);
        dumyNode.next = head
        ListNode now = dumyNode.next;
        ListNode pre = dumyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
            now = now.next;
        }
        //将now.next 插入到pre.next
        for (int i = 0; i < right-left; i++) {
            ListNode removed = now.next;
            now.next = removed.next;//这一步可以接上需要反转的后一个节点
            //注意这里不能接now，而是要接pre.next；因为removed在第一步一直在变
            // removed.next = now;
            removed.next = pre.next;
            pre.next = removed;
        }
        return dumyNode.next;
    }
}
