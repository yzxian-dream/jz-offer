package main.java.com;
/*旋转数组中的最小数字*/

/*题目描述:
      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
      输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
public class Title2 {
    //思路一:暴力法，依次查找比较寻出最小值，这种方法没什么意义，因为时间复杂度大且没用到题目中给出的条件
//时间复杂度为O(N)
  /*
   public int minNumberInRotateArray(int [] array) {
       if (array.length == 0){//若数组大小为0，请返回0
           return 0;
       }
       int min = array[0];
       for(int i = 1;i < array.length;i++){
           //min = min > array[i] ? array[i] : min;
           min = Math.min(min,array[i]);//均可
       }
       return  min;
    }
    */
//思路二：二分法
    /*
二分查找，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
[3,4,5,1,2]-->[3,4,5]和[1,2]
坑点：
1. 处于递增：L上移

2. 处于递减：R下移（如果是R-1，则可能会错过最小值，因为找的就是最小值）

3. 其余情况：L++缩小范围

    */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {//若数组大小为0，请返回0
            return 0;
        }
        int L = 0;//左边界
        int R = array.length - 1;//右边界
        while (L < R - 1) {//循环条件
            int mid = L + ((R - L) >> 1);//相当于(L+R)/2,但这样表达不如位运算执行的快，且防止溢出
            if (array[mid] >= array[L]) {//"="是为了防止有相等的数出现，比如[3,4,1,2,2,2]
                L = mid;//说明mid所在的位置是在第一个非递减子数列中
            } else if (array[mid] <= array[R]) {
                R = mid;//说明mid所在的位置是在第一个非递减子数列中
            }
        }
        return array[R];
    }
}


