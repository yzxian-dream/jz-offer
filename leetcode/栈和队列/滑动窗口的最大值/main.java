package 滑动窗口的最大值;
/* 
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。
 */

import java.util.LinkedList;
import java.util.Queue;

//暴力超时
public class main {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int n = len-k+1; //表示有多少个滑动窗口
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int maxValue = nums[i];
            for (int j = i; j < i+k; j++) {
                if (nums[j] > maxValue) {
                    maxValue = nums[j];
                }

            }
            temp[i] = maxValue;
        }
        return temp;
    }
}
//单调队列实现
/**
 * 单调队列是双端队列和且满足单调性，这个队列是双端队列，且从队首到队尾是单调递减的，队首就是最大值。
 */
public class main {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        if (nums.length < k) {
            return nums;
        }
        int index = 0;
        int n = nums.length - k + 1;
        int[] res = new int[n];
        //q存储nums下标
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //发现滑动窗口内后一个值大于当前队列的最后一个值时，那队列就把他移除，因为它永远不会成为最大值。
            //这一步可以保正将最大值放在q的第一位，比如q里2，1，这时候nums[2]=3,要进while了，就需要把2，1全部删除，让3成为第一位
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {//别忘了while,要一直比，小就一直删，保证单调队列
                q.pollLast();
            }
            q.add(i);
            //当超出一个滑动窗口的大小时，就把队列最前面的值poll出去()，以保证队列里时刻保存的是一个滑动窗口k的大小。

            //这一步实际上是来确定q里的最前面的元素（因为它最早进队列）还在不在滑动窗口内；这样写可以，但一开始没理解
            // if (q.peekLast() - k == q.peek()) { //q放的是下标
            //     q.poll();
            // }

            //也可以这样写，当前刚刚放入的下标是i和队首的下标的差值与k比较,>=k此时说明队首元素已经不在队列里了。
            if(i-q.peek()>=k){
                q.poll();//队首元素不在队列里了，在大也没用了
            }

            //当到达一个滑动串口大小的时候，就把q的第一位下标（最大值）对应到nums取出即可
            if (i + 1 >= k) { //别忘了>=
                res[index++] = nums[q.peek()];//别忘了nums，q.peek()是下标
            }
        }
        return res;
    }
}
