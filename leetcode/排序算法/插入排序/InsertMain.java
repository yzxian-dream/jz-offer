package 排序算法.插入排序;
//时间复杂度O（n^2)
import java.util.Arrays;

public class InsertMain {
    public static void main(int[] args) {
        int[] a = {155,34,119,1,89};
        insertSort(a);
    }
    public static int[] insertSort(int[] array) {
    //默认前面都是有序列表，那么第一位（index=0）数子就是最开始的有序列表，所以只需要处理len-1轮
    int len = array.length;
    for(int i=1;i<len;i++){
        //定义待插入数字
        //待插入数字为第二位index=1的数，那这个数字待插入位置应该是index-1的位置，就是它前面一位，因为它前面已经是一个有序的列表了（这个在脑子里首先要知道默认）
        int insertValue = array[i];
        int willInsertIndex = i-1;
        // 从已经排序的序列最右边的开始比较，找到比其小的数
        while (willInsertIndex>=0 && insertValue<array[willInsertIndex]) {
            array[willInsertIndex+1] = array[willInsertIndex];
            willInsertIndex--;
        }
        //直到打破while循环，1.一直找到起始位置，2.将要插入位置的数字<待插入数字。index+1,是因为while里多减去了1；
        array[willInsertIndex+1] = insertValue;
        System.out.println("第"+i+"轮");
        System.out.println(Arrays.toString(array));

    }
    return array;
    }
}
