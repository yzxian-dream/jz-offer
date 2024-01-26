package 排序算法.把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

/* 
 * 描述
输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323。
1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0

数据范围:
0<=len(numbers)<=100
 */
// class Solution {
//     public String crackPassword(int[] password) {
//         //本题关键是要比较，拼接后str(a)+str(b)<str(b)+str(a),按这个规则排序,可以利用冒泡排序或者快速排序来做，不过排序的规则要按照这个来
//         String[] arr = new String[password.length];
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = String.valueOf(password[i]);
//             Arrays.sort(arr, new Comparator<String>() {
//                 @Override
//                 public int compare(String o1,String o2){
//                     return (o1+o2).compareTo(o2+o1);
//                 }
//             });
            
//         }
//         String res = "";
//         for (String str : arr) {
//             res+=str;
//         }
//         return res;
//     }
// }

class Solution {
    public String crackPassword(int[] password) {
        String arr[] = new String[password.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(password[i]);
        }
        quickSort(arr, 0, arr.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public void quickSort(String[] arr,int left,int right){
        if (left >= right) {
            return;
        }
        int partitial = partitial(arr, left, right);
        quickSort(arr, left, partitial);
        quickSort(arr, partitial+1, right);
    }
    public int partitial(String[] arr,int left,int right){
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if ((arr[i]+arr[pivot]).compareTo(arr[pivot]+arr[i])<=0) {
                swap(arr,i,index++);
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
