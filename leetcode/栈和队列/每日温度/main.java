package 栈和队列.每日温度;
/*
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

 

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]
 

提示：

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */

import java.util.Stack;

/*
  * 单调栈做法
  单调栈是一种数据结构，用于解决一些与单调性相关的问题。它通常用于找到数组中每个元素的下一个更大元素或下一个更小元素。

在单调栈中，栈内元素保持单调递增或单调递减的顺序。
当遍历数组时，如果当前元素比栈顶元素大（或小），则将栈顶元素出栈，直到栈顶元素满足单调性要求。这样可以快速找到每个元素的下一个更大或更小元素。
  */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preindex = stack.pop();
                res[preindex] = i - preindex;
            }
            stack.push(i);
        }
        return res;
    }
}
