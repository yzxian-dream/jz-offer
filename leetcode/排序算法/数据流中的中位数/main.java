package 排序算法.数据流中的中位数;
/* 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */

import java.util.PriorityQueue;
import java.util.Queue;

//使用优先队列来构造大顶堆和小顶堆
//大顶堆和小顶堆分别存放n/2个元素，大顶堆存放较小的n/2个元素，小顶堆存放较大的n/2个元素，
//根据大小顶堆堆性质，那中位数只需要将堆顶元素(大的这一部分的最小值和小的这一部分的最大值)相加除以2就行，如果为奇数，多的那个数存入大根堆，那中位数就是大根堆的堆顶元素
//大根堆要么是和小根堆个数相同，要么是比小根堆个数多一个

//主要是插入操作
//当n是偶数，把新加的元素添加到小顶堆，把小根堆的堆顶元素放到大根堆。
//当n是奇数，把新加的元素添加到大根堆，把大根堆堆顶元素放到小根堆。

public class main {
    Queue<Integer> min,max;
        /** initialize your data structure here. */
    public MedianFinder() {
        //定义优先队列
        min = new PriorityQueue<>();//小根堆
        max = new PriorityQueue<>((x,y) -> (y-x));
    }
    
    public void addNum(int num) {
        //偶数
        if (min.size() == max.size()) {
            min.add(num);
            max.add(min.poll());
        }else{
            max.add(num);
            min.add(max.poll());
        }

    }
    //poll         移除并返问队列头部的元素    如果队列为空，则返回null
    //peek       返回队列头部的元素               如果队列为空，则返回null
    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek()+max.peek())/2.0;
        }else{
            return max.peek()*1.0;
        }
    }
}
