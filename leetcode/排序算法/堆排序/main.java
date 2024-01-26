package 排序算法.堆排序;

import java.util.Arrays;

/* 
堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：
即子结点的键值或索引总是小于（或者大于）它的父节点。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：

大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；

建堆的时间复杂度O(logN)
维护堆（heapify）的复杂度为O(logN)
堆排序对N个数进行heapify nlogn
堆排序是不稳定的

************
1. 算法步骤
创建一个堆 H[0……n-1]；

把堆首（最大值）和堆尾互换；

把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；

重复步骤 2，直到堆的尺寸为 1。

下标为i的节点的父节点下标：(i-1）/2  
下标为i的节点的左孩子下标：i*2+1
下标为i的节点的有孩子下标：i*2+2
 */

public class main {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr,len);
        return arr;
    }

    public void buildMaxHeap(int[] arr,int n){
        int i;
        //建堆(把无序堆建成大顶堆)
        //从最后一个节点的下标开始进行建堆
        for (i = (n-1-1)/2; i>=0; i--) {
            heapify(arr, n, i);
        }
        //此时已经建好了一个大顶堆
        //后面进行堆排序，将堆顶和尾元素交换，再进行heapify
        for (i = n-1; i>0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }
    /*
    维护堆的性质
     * arr:存储堆的数组
     * n:数组长度
     * i:待维护节点的下标
     */
    public void heapify(int arr[],int n,int i){
        int largest = i;
        int lson = i*2+1;
        int rson = i*2+2;
        if (lson < n && arr[largest] < arr[lson]) {
            largest = lson;
        }
        if (rson < n && arr[largest] < arr[rson]) {
            largest = rson;
        }
        if (largest != i) {
            swap(arr,i,largest);
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}




