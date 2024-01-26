package 排序算法.冒泡排序;
/* 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
针对所有的元素重复以上的步骤，除了最后一个；
重复步骤1~3，直到排序完成。 */
public class main {
    int[] bubbleSort(int[] arr) {
        if (arr.length == 0)
            return arr;
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
