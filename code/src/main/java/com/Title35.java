package main.java.com;

public class Title35 {
    int res = 0;

    public int InversePairs(int[] array) {
        //数组中的逆序对，归并排序
        if (array == null || array.length == 0)
            return 0;
        findInversePairs(array, 0, array.length - 1);
        return res % 1000000007;
    }

    public void findInversePairs(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            findInversePairs(array, low, mid); //左一半递归
            findInversePairs(array, mid + 1, high); //右一半递归
            //merge
            merge(array, low, mid, high);
        }
    }

    public void merge(int[] array, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else {   //大于，说明是逆序
                temp[k++] = array[j++];
                res += (mid - i + 1);
                res = res % 1000000007;
            }
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= high)
            temp[k++] = array[j++];

        for (i = 0; i < temp.length; i++)
            array[low + i] = temp[i];
    }
}
