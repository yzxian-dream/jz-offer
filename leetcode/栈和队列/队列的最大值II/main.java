package 队列的最大值II;
/* 
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 

限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
//LinkedList类实现了Queue,Deque接口，Deque接口扩展了Queue接口，三者都扩展或继承了Collection和Iterable接口。
//可以直接    LinkedList<Integer> deque; LinkedList<Integer> queue;
/* 
 * deque（双端队列）是一种具有两端插入和删除操作的数据结构。它允许在队列的两端进行插入和删除操作，因此可以在队列的前端和后端同时进行操作。
 * deque可以用作栈、队列或双向队列。

queue（队列）是一种先进先出（FIFO）的数据结构。它只允许在队列的一端进行插入操作（称为入队），
在另一端进行删除操作（称为出队）。队列可以用于模拟实际生活中的排队等待的场景。
 */
class MaxQueue {
    Queue<Integer> queue; //没有peekFirst()方法
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    //要保证peekfirst为最大值，就要让每次的offerlast为最大值
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
