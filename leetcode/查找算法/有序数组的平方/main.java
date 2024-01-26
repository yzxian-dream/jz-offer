package 查找算法.有序数组的平方;
/* 
 * 977.有序数组的平方
力扣题目链接(opens new window)

给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
#
 */
//暴力遍历每个数相乘（注意负数），排序

/* 
 * 双指针法
数组其实是有序的， 只不过负数平方之后可能成为最大数了。

那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。

此时可以考虑双指针法了，i指向起始位置，j指向终止位置。

定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。

如果A[i] * A[i] < A[j] * A[j] 那么result[k--] = A[j] * A[j]; 。

如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。
 */
public class main {
    public int[] sortedSquares(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;
        int[] res = new int[nums.length];
        while (left <= right) {
            if (nums[left]*nums[left]>nums[right]*nums[right]) {
                res[index--] = nums[left]*nums[left];
                left++;
            }else{
                res[index--] = nums[right]*nums[right];
                right--;
            }
        }  
        return res;
    }
}
