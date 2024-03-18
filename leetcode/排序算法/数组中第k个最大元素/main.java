package 排序算法.数组中第k个最大元素;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

 

示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
 

提示：

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class Solution {
    private int quickSelect(List<Integer> nums, int k) {
        // 随机选择基准数
        Random rand = new Random();
        //nextInt(nums.size()) 是调用 Random 对象的 nextInt 方法，生成一个介于 0（包含）和 nums.size()（不包含）之间的随机整数。这个整数可以作为列表的索引，用于从列表中选择一个元素。
        int pivot = nums.get(rand.nextInt(nums.size()));
        // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (nums.size() - small.size() < k)
            return quickSelect(small, k - big.size() - equal.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }
    
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList, k);
    }
}

