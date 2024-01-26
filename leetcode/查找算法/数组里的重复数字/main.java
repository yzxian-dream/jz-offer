package 数组里的重复数字;
/* 找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

 */
/* 
 * 时间复杂度：O(n)。
遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)，故总的时间复杂度是 O(n)。
空间复杂度：O(n)。不重复的每个元素都可能存入集合，因此占用 O(n) 额外空间。

 
import java.util.HashSet;
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!hashSet.add(num)){
                repeat = num;
            }
        }
        return repeat;
    }
}

*/
//时间复杂度O（n），空O(1)
import java.util.HashSet;

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            // 一直交换到下标值与下标相同（一次循环可以确定当前i == nums[i]）
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }

}