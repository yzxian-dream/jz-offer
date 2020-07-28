package main.java.com;
//3.从尾到头反转链表
//题目描述
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

import java.util.ArrayList;
import java.util.Stack;

//思路一：暴力顺利遍历一遍存储到临时集合templist中，在定义一个集合逆序遍历存储到
/*public class Title3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> tempList = new ArrayList<>();
        ListNode currNode = listNode;
        while (currNode != null) {//这里注意因为不知道循环次数所以是while循环，不是for
            tempList.add(currNode.val);
            currNode = currNode.next;
        }
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = tempList.size() - 1; i >= 0; i--) {
            resList.add(tempList.get(i));
        }
        return resList;

    }*/

//思路二
   /* listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，可以想到栈！
    ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
    所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后return list，这里有list一个特性，
     当往list中添加元素是，如果都添加到0位置，那么先添加到0位置的元素会被后来添加进来的元素往后挤，最后进来的元素会在0位置。
     而第一个到0位置的元素会被挤到末尾位置。这样返回的list是之前链表的逆序了，listNode 即可得到逆序链表
*/
   /*public class Title3 {
       public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
           ArrayList<Integer> list = new ArrayList<>();
           while (listNode != null) {
               list.add(0, listNode.val);
               listNode = listNode.next;
           }
           return list;
       }*/

//思路三
//listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，可以想到栈！
//先入栈，再用以一个链表接收弹栈值
/*public class Title3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }*/

//思路四
//递归法
/*
理解：要实现单链表的输出，那么就须要遍历。遍历的顺序是从头到尾。而节点输出的顺序是从尾到头。
因此，先遍历到的节点后输出。这是一个典型的 “后进先出”。

        要实现这种输出，能够使用栈，或，递归。
        通过这道题，让我对 “递归在本质上就是一个栈结构” 理解的更加深刻。
*/
//递归方法：递归的打印当前节点的下一个节点，但是这种方法当链表太多的时候，调用深度过深，速度很慢。
//堆栈方法：遍历一个节点加入堆栈，遍历完成出栈，利用了栈的先进后出的数据结构思想
//内部类
public class Title3 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }
        return solve(list,listNode);//因为solve返回的是ArrayList，而printListFromTailToHead也需要返回list，所以return
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> list, ListNode listNode) {
        //自定义方法来进行递归，先进后出，把细节处理完，也就是把链表反转在返回到printListFromTailToHead大局方法中，以便
        //直接调用printListFromTailToHead即可解决问题
        if(listNode.next == null){//递归出口条件，当为最后一个节点时
            list.add(listNode.val);//装最后一个节点数据值
            System.out.println(list);//[9]
            return list;//返回list,实际只包含最后一个节点值
        }
        list = solve(list, listNode.next);//一直递归调用，开辟栈内存（栈帧）来存放当前是第几个节点
        // 以及第一个--->倒数第二个节点对应的数据值
        list.add(listNode.val);//上箭头，
        // System.out.println(list);
        return list;//这里与栈的先进后出一致，0-9一次进来，9-0依次返回
    }
/*
[9]
[9, 8]
[9, 8, 7]
[9, 8, 7, 6]
[9, 8, 7, 6, 5]
[9, 8, 7, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3]
[9, 8, 7, 6, 5, 4, 3, 2]
[9, 8, 7, 6, 5, 4, 3, 2, 1]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]*/

    //测试代码
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode removeNode = head;//自定义一个移动节点去装尾节点
        for (int i = 1; i < 10; i++) {
            ListNode x = new ListNode(i);
            x.next = null;
            removeNode.next = x;
            removeNode = x;
        }
        System.out.println(printListFromTailToHead(head));
    }
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


//复杂度都一样
//时间复杂度：O(n)
// 空间复杂度：O(n)
