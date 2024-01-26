package 排序算法.最小的k个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.apple.laf.resources.aqua;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
    //可以采用堆排序和快速排序
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        //快排
        if (input == null || input.length == 0) {
            return new ArrayList<>();
        }
        return quickSort(input,0,input.length-1,k);
    }

    private ArrayList<Integer> quickSort(int[] input, int left, int right, int k) {
        int i = partitial(input,left,right);
        if (i+1 == k) {
            ArrayList<Integer> arrlist = new ArrayList<>();
            int[] arr = Arrays.copyOf(input,k);
            for (int j = 0; j < arr.length; j++) {
                arrlist.add(arr[j]);
            }
            return arrlist;
        }
        if (i+1>k) {
            return quickSort(input, left, i-1, k);
        }else{
            return quickSort(input, i+1, right, k);
        }
    }

    private int partitial(int[] input, int left, int right) {
        int povit = left;
        int index = povit+1;
        for (int i = index; i <= right; i++) {
            if (input[i] < input[povit]) {
                swap(input,i,index);
                index++;
            }
        }
        swap(input, povit, index-1);
        return index-1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}