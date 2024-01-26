package 在排序数组中查找数字I;
/* 
 * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。

 
https://www.cnblogs.com/kyoner/p/11080078.html
3. 为什么 left = mid + 1，right = mid ？和之前的算法不一样？

答：这个很好解释，因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间，即 [left, mid) 或 [mid + 1, right)。
先来梳理一下这些细节差异的因果逻辑：

第一个，最基本的二分查找算法：

因为我们初始化 right = nums.length - 1
所以决定了我们的「搜索区间」是 [left, right]
所以决定了 while (left <= right)
同时也决定了 left = mid+1 和 right = mid-1

因为我们只需找到一个 target 的索引即可
所以当 nums[mid] == target 时可以立即返回
第二个，寻找左侧边界的二分查找：

因为我们初始化 right = nums.length
所以决定了我们的「搜索区间」是 [left, right)
所以决定了 while (left < right)
同时也决定了 left = mid+1 和 right = mid

因为我们需找到 target 的最左侧索引
所以当 nums[mid] == target 时不要立即返回
而要收紧右侧边界以锁定左侧边界
第三个，寻找右侧边界的二分查找：

因为我们初始化 right = nums.length
所以决定了我们的「搜索区间」是 [left, right)
所以决定了 while (left < right)
同时也决定了 left = mid+1 和 right = mid

因为我们需找到 target 的最右侧索引
所以当 nums[mid] == target 时不要立即返回
而要收紧左侧边界以锁定右侧边界

又因为收紧左侧边界时必须 left = mid + 1
所以最后无论返回 left 还是 right，必须减一

示例 1：

输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
输出: 3
示例 2：

输入: scores = [1, 2, 3, 5, 7, 9], target = 6
输出: 0
 

提示：

0 <= scores.length <= 105
-109 <= scores[i] <= 109
scores 是一个非递减数组
-109 <= target <= 109
 */
// class Solution {
//     public int search(int[] nums, int target) {
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

//二分法
//寻找左起第一个等于target的值,往其中一边无限逼近
// class Solution {
//     public int search(int[] nums, int target) {
//         int left = findBeginPostion(nums, target);
//         int right = findEndPostion(nums, target);
//         if (left < 0 || right < 0) {
//             return 0;
//         }
//         return right-left+1;
//     }

//     int findBeginPostion(int[] nums, int target) {
//         if (nums == null || nums.length == 0) {
//             return -1;
//         }
//         int left = 0;
//         int right = nums.length - 1;
//         while (left <= right) {
//             int mid = (left+right)/2;
//             if (nums[mid]==target) {
//                 /* 
//                  * 找左起第一位重复数字，要判断一下如果mid=0,那么已经处于最左边了，肯定是重复数字序列的第一位
//                  * 如果不满足，则左边可能还是存在一样的数字，就需要将有边界移到当前mid下标的前一位。
//                  */
//                 if (mid == 0 || nums[mid-1] < target) {
//                     return mid;
//                 }
//                 right = mid - 1;
//             }else if (nums[mid] > target) {
//                 right = mid - 1;
//             }else{
//                 left = mid + 1;
//             }
//         }
//         //如果没有这个target，返回-1
//         return -1;
//     }


// //寻找最后一个等于target的值,往其中一边无限逼近

//     int findEndPostion(int[] nums, int target) {
//         if (nums == null || nums.length == 0) {
//             return -1;
//         }
//         int len = nums.length;
//         //定义左右边界指针，left指针只能往右，right指针只能往左
//         int left = 0;
//         int right = len - 1;
//         while (left <= right) {
//             int mid = (left+right)/2;
//             if (nums[mid] == target) {
//                 if (mid == len-1 || nums[mid+1]>target) {
//                     return mid;
//                 }
//                 //要找出右边最后一个index,所以当相等的时候就不能移动right指针，
//                 left = mid + 1;
//             }else if (nums[mid]<target) {
//                 left = mid + 1;
//             }else{
//                 right = mid - 1;
//             }
//         }
//         return -1;
//     }
// }


 class Solution {
    public int countTarget(int[] array,int target) {
        if (array.length == 0) {
            return 0;
        }
        int left = findleft(array, target);
        int right = findright(array, target);
        if (left < 0 || right < 0) {
            return 0;
        }
        int res = right - left + 1;
        return res;
    }
    public int findleft(int[] array,int target){
        int left = 0;
        int right = array.length;   //查左右边界这样定义，养成习惯
        
        while (left<right) {     //这里也是，就不能=了
            int mid = (left+right)/2;
            if (array[mid] == target) {  
                if (mid == 0 || array[mid-1]<target ) {
                    return mid;
                }
                right = mid;
            }else if (array[mid]>target) {
                right = mid;
            }else if (array[mid]<target) {
                left = mid+1;
            }
        }
        return -1;
    }

    public int findright(int[] array,int target){
        int left = 0;
        int right = array.length;
        while (left<right) {
            int mid = (left+right)/2;
            if (array[mid] == target) {
                if (mid == array.length-1 || array[mid+1]>target) {
                    return mid;
                }
                left = mid+1;
            }else if (array[mid] > target) {
                right = mid;
            }else if (array[mid] < target) {
                left = mid+1;
            }
        }
        return -1;
    }
}
