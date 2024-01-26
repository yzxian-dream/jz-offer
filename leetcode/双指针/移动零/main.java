package 移动零;
/* 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

 

示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]
 

提示:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
//暴力法可以采用冒泡排序
// public class main {
//     public void moveZeroes(int[] nums) {
//         for (int i = 0; i < nums.length-1; i++) {
//             for (int j = 0; j < nums.length-1-i; j++) {
//                 if (nums[j] == 0 && nums[j] != nums[j+1]) {
//                     swap(nums,i,j);
//                 }
//             }
//         }
//     }
// }
//定义一个快慢指针，快指针一直走，当快指针的值不等于0时，慢指针后期在每次交换完实际上都是指的0；
public class main {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                swap(nums,l,r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
