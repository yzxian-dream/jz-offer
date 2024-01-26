package 排序算法.快速排序;
/* 
 * 从数列中挑出一个元素，称为 "基准"（pivot）;

重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）
。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；

递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
快速排序的最坏运行情况是 O(n²)，比如说顺序数列的快排。但它的平摊期望时间是 O(nlogn)，且 O(nlogn) 
记号中隐含的常数因子很小，比复杂度稳定等于 O(nlogn) 的归并排序要小很多。所以，对绝大多数顺序性较弱的随机数列而言，
快速排序总是优于归并排序。
 */
public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    /* 
     * 新的寻找partitial的方法
     */
    // private int partition(int[] arr, int left, int right) {  
    //     // 设定基准值（pivot）
    //     int pivot = arr[left];
    //     int i = left + 1;
    //     int j = right;
    //     while (i < j) {
    //         //从左往右找到第一个大于中间值的下标
    //         while (i <= j && arr[i]<=pivot) {
    //             i++;
    //         }
    //         //从右往左找到丢一个小于中间值的下标
    //         while (i <= j && arr[j]>=pivot) {
    //             j--;
    //         }
    //         if (i>=j) {
    //             break;
    //         }
    //         swap(arr, i, j);
    //     }
    //     arr[left] = arr[j];
    //     arr[j] = pivot;
    //     return j;
    // }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}