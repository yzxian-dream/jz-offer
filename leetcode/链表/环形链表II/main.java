package 环形链表II;
/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

不允许修改 链表。

 

示例 1

输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
 

提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
 */

 //快慢指针的做法，假设链表起点到环的入口节点长度为A,当slow节点和fast节点在环的某处相遇时，设环的起点到第一次相遇的位置的距离为B,环剩余的距离为c，
 //由于快指针每次走两步，肯定会多走一圈来遇见慢指针，那么快指针走了A+2B+C,慢指针走了A+B，由于fast每次走的是slow的两倍，那么A+2B+C=2(A+B),得出A==C
 //那么先slow丢在相遇的位置，另外在new 一个slow去起点，在一起开始每次走一步，由于A=C,所以在此相遇时一定处于环的入口点

 /**
  * class ListNode{
     int val;
     ListNode next;
     public ListNode(int val){
        this.val = val;
        this.next = null;
     }
  }
  */
// public class main {
//     public ListNode detectCycle(ListNode head) {
//         if (head == null || head.next == null) {
//             return null;
//         }

//         ListNode slow = head;
//         ListNode fast = head;

//         while (true) {
//             if (fast == null || fast.next == null) {
//                 return null;
//             }
//             fast = fast.next.next;
//             slow = slow.next;
//             if (fast == slow ) {
//                 break;
//             }

//         }
//         ListNode newSlow = head;
//         while (newSlow != slow) {
//             slow = slow.next;
//             newSlow = newSlow.next;
//         }
        
//         return slow;
        

//     }
// }

//方法2，用hashset装节点，当有第一个重复节点装不进去就代表这个节点是入口节点。，一般方法一高级
public class main {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.add(cur)) {
                cur = cur.next;
            }else{
                return cur;
            }
        }
        return null;
    }
}