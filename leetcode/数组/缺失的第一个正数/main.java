package 数组.缺失的第一个正数;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 

示例 1：

输入：nums = [1,2,0]
输出：3
示例 2：
输入：nums = [3,4,-1,1]
输出：2
示例 3：

输入：nums = [7,8,9,11,12]
输出：1
 

提示：

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
 */

 //方法1 HashSet
// public class main {
//     public int firstMissingPositive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }
//         for (int i = 1; i <= nums.length; i++) {
//             if (!set.contains(i)) {
//                 return i;
//             }
//         }
//         return nums.length+1;
//     }

// }
//最小正整数为1
//所以最终是让数组中下表为0的位置存放最小正整数1，下表为1的位置存放2，以此类推，存完后，一一对应，下表与值不对应的就是缺失的
//此题可以参考0～n中重复数字
// [3,4,-1,1]

// 添加到测试用例
// 输出
// 1
// 预期结果
// 2
public class main {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            /**
             * 这里如果不加nums[nums[i]-1] != nums[i]这个条件，如果输入数组是[1,1];将一直处于while循环出不来，超出时间限制
             * 因此当nums[i] == nums[nums[i]-1]的时候就表示nums[i]已经处于正确位置了，跳出循环。
             */
            while (nums[i]>0 && nums[i]<=nums.length && nums[i]!= i+1 && nums[nums[i]-1] != nums[i])  {
                //这里不能直接这样交换，否则nums[i]已经改变，交换超出边界
                // int temp = nums[i];
                // nums[i] = nums[nums[i]-1];
                // nums[nums[i]-1] = temp;

                //定义swap进行交换
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
