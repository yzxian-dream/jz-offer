package k个一组反转链表;
/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：



输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
 

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 
[1,2,3,4,5]
k =
3
输出
[3,2,5,4]
预期结果
[3,2,1,4,5]

head =
[1,2,3,4,5]
k =
2
输出
[2,1,4,3]
预期结果
[2,1,4,3,5]

进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
// public class main {
//     public ListNode reverseKGroup(ListNode head,int k) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode dumyNode = new ListNode(0);
//         ListNode newHead = dumyNode;
//         // dumyNode.next = head;
//         ListNode cur = head;
        
//         while (cur != null) {
//             // if(cur.next != null){
//             //     newHead.next = cur;
//             // }
//             ListNode nextHead = cur;//1,3,5
//             for(int i = 0;i<k;i++){
//                 if (nextHead != null) {
//                     nextHead = nextHead.next;//3,5,null
//                 }else{
//                     nextHead = null;
//                 }
//             }
//             ListNode temp = nextHead;//3,5,null
//             ListNode newNode = reverse(cur,k);//2-->1, 4-->3,5
//             // if (temp != null && temp.next == null) {
//             //     newHead.next.next = temp;
//             // }
//             newHead.next = newNode;//0-->2-->1--->4-->3--->5
//             newHead = cur;//1,3,5
//             cur = temp;//3,5
            
//             // newHead = newNode.next;
            

//         }
//         return dumyNode.next;

//     }
//     public ListNode reverse(ListNode head,int k){
//         ListNode pre = null;
//         ListNode cur = head;
//         ListNode cur1 = head;
//         int count = 0;
//         while (cur1 != null) {
//             count++;
//             cur1 = cur1.next;
//         }
//         if (count < k) {
//            return head; 
//         }
//         // if (head.next == null) {
//         //     return head;
//         // }
//         for (int i = 0; i < k; i++) {
//             if (cur != null) {
//                 ListNode temp = cur.next;
//                 cur.next = pre;
//                 pre = cur;
//                 cur = temp;
//             }else{
//                 break;
//             }
            
//         }
//         return pre;
//     }
// }
/**
 * main
 */
public class main {
    public ListNode reverseKGroup(ListNode head,int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumyNode = new ListNode(0);
        dumyNode.next = head;
        ListNode pre = dumyNode,end = dumyNode;

        while(end.next != null){
            for(int i=0;i<k;i++){
                end = end.next;
                //这个for循环不能放在里面，否则后面end.next null pint
                // if(end == null){
                //     break;
                // }
                
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;

            //此时end为当前组的最后节点
            ListNode next = end.next;
            end.next = null;//暂时打断与下一组的链接，独立成一个当前组的k个节点,important！
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dumyNode.next;
      }
        public ListNode reverse(ListNode head){
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }
}


