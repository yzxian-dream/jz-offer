package 合并k个升序列表;

import 回文链表.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

 

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]
 

提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

 */
/**
 * 自己的做法，基于合并两个有序链表的基础上进行实现的，但看了官方做法，写法上可以把合并两个给抽出来独立成一个方法
 */
// public class main {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0 || lists == null) {
//             return null;
//         }
//         if (lists.length == 1) {
//             return lists[0];
//         }
//         int len = lists.length;
//         ListNode dumyNode = new ListNode(-1);
//         ListNode temp = dumyNode;
//         ListNode head1 = lists[0];
//         ListNode temp1 = head1;
//         for (int i = 1; i < len; i++) {
//             ListNode head2 = lists[i];
//             ListNode temp2 = head2;
//             while (temp1 != null && temp2 != null) {
//                 if (temp1.val <= temp2.val) {
//                     temp.next = temp1;
//                     temp1 = temp1.next;
//                 }else{
//                     temp.next = temp2;
//                     temp2 = temp2.next;
//                 }
                
//                 temp = temp.next;
                
//             }
//             if (temp1 != null) {
//                 temp.next = temp1;
//             }
//             if (temp2 != null) {
//                 temp.next = temp2;
//             }
//             temp1 = dumyNode.next;
//             temp = dumyNode;

//         }
//         return dumyNode.next;
//     }
// }

/**
 * 时间复杂度：假设每个链表的最长长度是 nnn。在第一次合并后，ans\textit{ans}ans 的长度为 nnn；第二次合并后，ans\textit{ans}ans 的长度为 2×n2\times n2×n，第 iii 次合并后，ans\textit{ans}ans 的长度为 i×ni\times ni×n。第 iii 次合并的时间代价是 O(n+(i−1)×n)=O(i×n)O(n + (i - 1) \times n) = O(i \times n)O(n+(i−1)×n)=O(i×n)，那么总的时间代价为 O(∑i=1k(i×n))=O((1+k)⋅k2×n)=O(k2n)O(\sum_{i = 1}^{k} (i \times n)) = O(\frac{(1 + k)\cdot k}{2} \times n) = O(k^2 n)O(∑ 
i=1
k
​
 (i×n))=O( 
2
(1+k)⋅k
​
 ×n)=O(k 
2
 n)，故渐进时间复杂度为 O(k^2 n)
空间复杂度：没有用到与 kkk 和 nnn 规模相关的辅助空间，故渐进空间复杂度为 O(1)。

 */
// public class main {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode ans = null;
//         for (int i = 0; i < lists.length; ++i) {
//             ans = mergeTwoLists(ans, lists[i]);
//         }
//         return ans;
//     }

//     public ListNode mergeTwoLists(ListNode a, ListNode b) {
//         if (a == null || b == null) {
//             return a != null ? a : b;
//         }
//         ListNode dumyNode = new ListNode(0);
//         ListNode temp = dumyNode, aPtr = a, bPtr = b;
//         while (aPtr != null && bPtr != null) {
//             if (aPtr.val < bPtr.val) {
//                 temp.next = aPtr;
//                 aPtr = aPtr.next;
//             } else {
//                 temp.next = bPtr;
//                 bPtr = bPtr.next;
//             }
//             temp = temp.next;
//         }
//         temp.next = (aPtr != null ? aPtr : bPtr);
//         return dumyNode.next;
//     }
// }
//这种排序的都可以考虑分治的做法，分到最小递归治理
public class main {
    public ListNode mergeKLists(ListNode[] lists) {
        int left = 0;
        int right = lists.length-1;
        return mergeSort(lists,left,right);
    }
    public ListNode mergeSort(ListNode[] lists,int l,int r){
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l+(r-l)/2;
        ListNode list1 = mergeSort(lists, l, mid);
        ListNode list2 = mergeSort(lists, mid+1, r);
        return merge(list1,list2);
    }

    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dumyNode = new ListNode(-1);
        ListNode temp = dumyNode;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        if (temp1 == null || temp2 == null) {
            return temp1 == null ?temp2:temp1;
        }
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }else{
            temp.next = temp2
        }
        return dumyNode.next;
    }
}