package 数学.颜色分类;
/*
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库内置的 sort 函数的情况下解决这个问题。

 

示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]
 

提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
 */

 /*
  * 实际就是将0，1，2进行排序
  */
class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int left = -1;
        int right = nums.length;
        int i = 0;
        while(i < right) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 0) {
                swap(nums, left + 1, i);
                left++;
                i++;
            } else {
               swap(nums, right - 1, i);
               right--; 
            }
        }
    }
    void swap(int [] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
 }