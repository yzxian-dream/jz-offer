package 旋转数组的最小数字;
/* 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 ：
输入：[3,4,5,1,2]
输出：1
 */
import java.util.Arrays;

// class Solution {
//     public int minArray(int[] numbers) {
//         Arrays.sort(numbers);
//         return numbers[0];
//     }
// }

//使用二分法
// 1 2 3 4 5 ---> 3 4 5 1 2 ,旋转点是1，这里分成3 4 5 和 1，2 两块，因为原数组是升序的，所以第一部分的第一个数肯定是大于等于第二部分最后一个数；
class Solution {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length-1;
        while (l<r) {
            int mid = (l+r)/2;
            //说明旋转点在右半部分
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            }else if (numbers[mid] < numbers[r]) {
                //说明旋转点在左半部分，但是 不能确定此时的mid是不是旋转点，所以r不能=mid-1；
                r = mid;
            }else{
                //当numbers[mid]==numbers[r],就不好确定，要么一次左移右指针，要取该区间最小值 
                findmin(numbers, l, r);
                // r--;                                                                    
            }
        }
        return numbers[l];
    }


    public int findmin(int[] a, int l,int r) {
        int minres = a[l];
        for (int i = 0; i < a.length; i++) {
            if (a[i]<minres) {
                minres = a[i];
            }
        }
        return minres;
    }
}

public int stockManagement(int[] arr) {
      int l = 0;
      int r = arr.length - 1;
      while (l <= r) {
        int mid = (l+r)/2;
        if (arr[mid] > arr[r]) {
          l = mid+1;
        }else if (arr[mid] < arr[r]) {
          r = mid;
        }else{
          r--;
        }
      }
      return arr[r+1];
   }