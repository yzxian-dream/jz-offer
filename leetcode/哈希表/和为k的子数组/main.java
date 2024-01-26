package 哈希表.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。

 

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2
 

提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int sum = 0;

//             for (int j = i; j >= 0; j--) {
//                 sum += nums[j];
//                 // count++;
//                 if (sum == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

// }

/**
 * 时间复杂度：O(n2)，其中 n 为数组的长度。枚举子数组开头和结尾需要 O(n2) 的时间，其中求和需要 O(1) 的时间复杂度，因此总时间复杂度为
 * O(n2)
 * 
 * 
 * 空间复杂度：O(1)。只需要常数空间存放若干变量。
 * 
 */


// @lc code=end
//方法二 前缀和加哈希表优化
/**
 * 方法一中对于每个i,需要枚举所有的j来判断是否符合条件，这一步可以优化，我们定义pre[i]表示[0...i]里所有数的和，则pre[i]可以由
 * pre[i-1]递推而来，即：pre[i]=pre[i-1]+nums[i],那么我们要求[j...i]这个子数组和为k,这个条件可以转化为pre[i]-pre[j-1]=k
 * 也就是前i个数的和-前j-1个数的和，差值就是nums[j]+nums[j+1]+...+nums[i-1]+nums[i]=k, 
 * pre[i]-k=pre[j-1];那么问题以i为结尾的和为k的连续子数组个数只要统计有多少个前缀和为pre[i]-k的pre[j]即可，建立哈希表mp，以和为键，出现次数为对应的值
 * 需要注意的是，从左往右边更新边计算的时候已经保证了mp[pre[i]−k] 里记录的 pre[j]的下标范围是 0≤j≤i 。同时，由于pre[i]] 的计算只与前一项的答案有关，因此我们可以不用建立 pree 数组，直接用 pre 变量来记录 pre[i−1]的答案即可

 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //初始化的时候要加进去
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}