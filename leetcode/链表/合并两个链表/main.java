package 合并两个链表;
/* 
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
输出：[0,1,2,1000000,1000001,1000002,5]
解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 */
public class main {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left = list1;
        for (int i = 1; i < a; i++) {
            left = left.next;
        }
        ListNode middle = left;
        // middle.next = list2;
        for (int i = a; i <= b; i++) {
            middle = middle.next;
        }
        left.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = middle.next;

    }
}
