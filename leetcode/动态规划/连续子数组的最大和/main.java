package 连续子数组的最大和;

 /* 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 

提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100


 */
// class Solution {
//     public int maxSubArray(int[] nums) {
//         if (nums.length == 1) {
//             return nums[0];
//         }
//         int[] dp = new int[nums.length];

//         dp[0] = nums[0];
//         for (int i = 1; i < dp.length; i++) {
//             // dp[i] = nums[i] + nums[i-1];
//             //如果前面的最大和为负数，那当前的num[i]就独立成一个组成数组就是最大值，无需加上前面的最大和
//             if (dp[i-1]<0) {
//                 dp[i] = nums[i];
//             }else{
//                 dp[i] = nums[i]+dp[i-1];
//             }
//         }
//         return getMax(dp);
        
//     }

//     int getMax(int[] res){
//         int max = res[0];
//         for (int i = 1; i < res.length; i++) {
//             if (res[i]>max) {
//                 max = res[i];
//             }
//         }
//         return max;
//     }
// }      
//思路，如果前面的数之后小于0；就统一舍弃掉，dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
//有个好方法获取最大值
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            // dp[i] = nums[i] + nums[i-1];
            //如果前面的最大和为负数，那当前的num[i]就独立成一个组成数组就是最大值，无需加上前面的最大和
            if (dp[i-1]<0) {
                dp[i] = nums[i];
            }else{
                dp[i] = nums[i]+dp[i-1];
            }
            if (dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
        
    }
}  
