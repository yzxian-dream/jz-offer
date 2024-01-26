package 分治算法.数组中的逆序对;

/* 
 * 描述
在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。

 

示例 1:

输入：record = [9, 7, 5, 4, 6]
输出：8
解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。


 */
public class main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组
     * @return int整型
     */
    // 可以用冒泡排序，冒泡排序交换的次数就是逆序对的总数，但是时间复杂度是O(n^2),会超出时间限制
    // 所以可以采用归并排序来做

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (r - l) / 2 + l;
        int x1 = mergeSort(nums, l, mid);
        int x2 = mergeSort(nums, mid + 1, r);
        int x3 = merge(nums, l, mid, r);
        return x1 + x2 + x3;
    }

    public int merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int j = mid + 1;
        int i = l;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count = count + (mid - i + 1);
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }
        //将临时数组放回原数组
        k = 0;
        //注意这里不能从0开始，而是要从当前的左边下标开始
        for (int m = l; m <= r; m++) {
            nums[m] = temp[k++];
        }
        return count;
    }

}
