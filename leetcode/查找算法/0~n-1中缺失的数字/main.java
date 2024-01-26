package mains;
/* 
 * 题目描述：
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例：

输入: [0,1,3]
输出: 2

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
————————————————
版权声明：本文为CSDN博主「strive_day」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_40542534/article/details/108554664
 */
// class Solution {
//     public int missingNumber(int[] nums) {

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != i) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if (nums[mid] == mid) {
                l = mid+1;
            }else{

                r = mid-1;
            }
        }
        //找到最后一个还没找到，输出下一个，比如输入[0],返回1；
        return nums[l] == l ? l+1:l;
    }
}

//注意二分法的结束条件l<=r

// class Solution {
//     public int missingNumber(int[] nums) {
//         int l = 0;
//         int r = nums.length-1;
//         while(l<r){
//             int mid = (l+r)/2;
//             if (nums[mid] == mid) {
//                 l = mid+1;
//             }else{
//                 r = mid;
//             }
//         }
//         return l;
//     }
// }


// class Solution {
//     public int missingNumber(int[] nums) {
//         int l = 0;
//         int r = nums.length - 1;
//         while (l <= r) {
//             int mid = (l + r) / 2;
//             if (nums[mid] != mid) {
//                 r = mid - 1;
//             } else {
//                 l = mid + 1;
//             }

//         }
//         return l;
//     }
// }