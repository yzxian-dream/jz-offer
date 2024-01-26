package 合并两个排序链表;

// class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode node = new ListNode();
//        ListNode mergecur = node;
//        while(l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                mergecur.next = l1;
//                l1 = l1.next;
//            }else{
//                mergecur.next = l2;
//                l2 = l2.next;
//            }
//            mergecur = mergecur.next;
//        }
//        if (l1 != null){
//            mergecur.next = l1;
//        }
//        if(l2 != null){
//            mergecur.next = l2;
//        }
//         return node.next;
//     }
// }

//思路二递归


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 有一个为空 直接返回另一个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 比较获取小链表
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
