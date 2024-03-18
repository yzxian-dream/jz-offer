package 柱状图中最大矩形;
/*
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 

示例 1:



输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：



输入： heights = [2,4]
输出： 4
 

提示：

1 <= heights.length <=105
0 <= heights[i] <= 104
 */

 //单调栈做法
/*
 * 随后我们需要进行向左右两边扩展，使得扩展到的柱子的高度均不小于 h。换句话说，我们需要找到左右两侧最近的高度小于 h 的柱子，这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h，并且就是 i 能够扩展到的最远范围。

。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        //我们需要求出每一根柱子的左侧且最近的小于其高度的柱子。初始时的栈为空。
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }
        //求出每一根柱子的右侧且最近的小于其高度的柱子。初始时的栈为空。
        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            //这里-1的原因是，左右两侧检测到的边界是不包括算面积的底边长里的，比如576三个柱子，左右边界的index分别为0，2，实际对于7这个柱子算最大面积的时候就是7*1。所以index为0和2的不包括在内
            //对于5这个柱子是5*3,5的左边界是-1，右边界是3，
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}

