package 乘积最大子数组;
/*
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
子数组
（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。

 

示例 1:

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 

提示:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 */

 /*
  * 标签：动态规划
遍历数组时计算当前最大值，不断更新
令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
当负数出现时则imax与imin进行交换再进行下一步计算
时间复杂度：O(n)O(n)O(n)

作者：画手大鹏
链接：https://leetcode.cn/problems/maximum-product-subarray/solutions/7561/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  */
public class main {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;//结果最大值
        int imax = 1,imin = 1 ;//阶段最大值和阶段最小值
        for (int num : nums) {
            //当遇到负数的时候进行交换，因为阶段最小*负数就变成阶段最大了，反之同理
            if (num < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            //在这里用乘积和元素本身比较的意思是：
            //对于最小值来说，最小值是本身则说明这个元素值比前面连续子数组的乘积还小，相当于重制了阶段最小值的起始位置
            imax = Math.max(imax*num,num);
            imin = Math.min(imin*num,num);
            //对比阶段最大值和结果最大值
            max = Math.max(max, imax);
        }
        return max;
    }
}
