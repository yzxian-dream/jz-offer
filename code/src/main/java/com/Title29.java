package main.java.com;
/*
*  题目描述：

  输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

  解题思路：

  本题最直观的解法就是将输入的n个整数排序，排序之后位于最前面的k个数就是最小的k个数，这取决于排序的时间复杂度，最快为O(nlogn)。

  当我们可以对输入的数组进行修改时，可以得到一种更快的解法。类似于快速排序的思想，
* 基于Partition函数来解决这个问题，如果我们选取数组的第n个数字（记为key）来进行数组重排，那么比key小的所有数字都位于数组的左边，
* 比key大的所有数字都位于key之后，也就是数组的右边。

  因此，我们只需要判断key的下标是否等于k-1，等于时返回其左边的K个数便是最小的K个数。当key的下标小于k-1时，就在右边继续划分，
* 反之左边继续划分。由此我们可以得到以下代码实现，时间复杂度为O(n)。*/
import java.util.ArrayList;

public class Title29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        //方法一：排序
        //方法二：partition分组
        ArrayList<Integer> res=new ArrayList<>();
        if(input==null || input.length<=0 || k>input.length)
            return res;
        int len=input.length;
        int low=0,high=len-1;
        int index=-1;
        while(low<high && index!=k){
            index=partition(input,low,high);
            if(index>k)
                high=index-1;
            else
                low=index+1;
        }

        for(int i=0;i<k;i++)
            res.add(input[i]);
        return res;
    }
    //划分算法，返回的i左边都比他小，右边都比他大
    public int partition(int[] array,int low,int high) {
        int left = low, right = high + 1;
        int key = array[low];
        while (true) {
            while (array[--right] > key) {
                if (right == low) {
                    break;
                }
            }
            while (array[++left] < key) {
                if (left == high) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exch(array, left, right);
            }
        }

        exch(array, low, right);
        return right;
    }

    public static void exch(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

 }