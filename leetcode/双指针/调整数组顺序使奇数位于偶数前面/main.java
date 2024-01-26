package 调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;
//思路一：双指针移到另一个数组里

// class Solution {
//     public int[] exchange(int[] array) {
//      int len = array.length;
//         //辅助数组b
//         int b[] = new int[len];
//         int i = 0;                 //指针1，从前往后 寻找奇数
//         int i1 = i;
//         int j = array.length - 1;  //指针2，从后往前 寻找偶数
//         int j1 = j;

//         while (i1 < len && j1 >= 0) {    //终止条件
//             //判断奇数
//             if (array[i1] % 2 == 1) {    
//                 b[i++] = array[i1];
//             }        
//             i1++;    //右移指针i

//             //判断偶数
//             if (array[j1] % 2 == 0) {    
//                 b[j--] = array[j1];
//             }          
//             j1--;    //左移指针j
//         }
//         return b;
//     }
// }
//思路二，双指针交换位置.稳定调整，头到尾，没遇到偶数，就left++,尾到头没遇到奇数，就right--；
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}