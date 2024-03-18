import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.crypto.Mac;
import javax.swing.tree.TreeNode;
/* 
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

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

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

s.length <= 40000


 */
class Solution {
  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    Stack<Integer> monoStack = new Stack<>();
    int[] left = new int[len];
    int[] right = new int[len];
    for (int i = 0; i < len; i++) {
      while (!monoStack.isEmpty() && heights[monoStack.peek()]>heights[i] ) {
        monoStack.pop();
      }
      left[i] = monoStack.isEmpty() ? -1:monoStack.peek();
      monoStack.push(i);
    }
    monoStack.clear();
    //找出右侧最近且小于当前柱子的下标
    for (int i = len-1; i >= 0; i--) {
      while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
        monoStack.pop();
      }
      right[i] = monoStack.isEmpty() ? len:monoStack.peek();
      monoStack.push(i);
    }
    int res = 0;
    for (int i = 0; i < len; i++) {
      res = Math.max(res, (right[i]-left[i]-1)*heights[i]);
    }
    return res;
  }
}
