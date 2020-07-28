package main.java.com;

import java.util.ArrayList;

/*题目描述：

   输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
   如果有多对数字的和等于S，输出两个数的乘积最小的。*/
public class Title42 {
   public ArrayList<Integer> FindNumbersWithSum (int[] array, int sum) {
       ArrayList<Integer> res = new ArrayList<>();
       int L = 0;
       int R = array.length - 1;
       while (L < R) {
           int curSum = array[L] + array[R];
           if (curSum == sum) {
               res.add(array[L]);
               res.add(array[R]);
               break;//不能省略，跳出循环有，不然循环不减
           } else if (curSum > sum) {
               R--;
           } else {
               L++;
           }
       }
       return res;
   }
}
