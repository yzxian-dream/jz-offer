package 排序算法.归并排序;

//利用归并的思想实现排序，该算法采用经典的分治策略
//（将问题分成一些小的问题然后递归求解，而治的阶段则是将分的阶段得到的各答案修补在一起，即分而治之）
public class main {

    public static void main(String[] args) {
        int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left <= right) {
            int mid = (left + right) / 2;
            // 向下递归而分
            // 先分左边
            mergeSort(arr, left, mid, temp);
            // 再分右边
            mergeSort(arr, mid + 1, right, temp);
            // 分而治之,合并arr.length-1次
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        // int mid = (left+right)/2;
        int i = left; // 初始化i,左边有序序列的初始索引
        int j = mid + 1;// 初始化j，右边有序序列的最左边索引（初始索引）
        int t = 0;// 临时存储数组的当前索引
        // 先把两边序列头部数字对比，把更小的放进临时数组
        // 直到两边的有序序列有一边处理完为止
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }
        // 右边已到尽头，左边还有剩余，左边一次放入临时数组即可。
        while (i <= mid) {
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        // 左边已到尽头，右边还有剩余，右边一次放入临时数组即可。
        while (j <= right) {
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }
        // 将temp数组元素拷贝到arr
        // 注意并不是每次都拷贝所有，而是，刚开始的两个先放入数组，再取出来，在比，在存入临时数组，在放入数组，再取...，以供执行arr.length-1次
        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            templeft += 1;
            t += 1;
        }

    }
}
