package main.java.com;

/*题目描述：调整数组顺序使奇数位于偶数前面

          输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
        所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
/*
public class Title13 {
    public void reOrderArray(int[] array){
        int len = array.length;
        for (int i = 0; i < len ; i++) {
            if (array[i] % 2 != 0){
                for (int j = i-1; j >= 0; j--) {
                    if (array[j] % 2 == 0){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
        }

    }
}

*/
public class Title13 {
    public void reOrderArray(int[] array) {

        int len = array.length;
        int even = 0, odd = 0; //当前序列的第一个奇数和第一个偶数
        while (odd < len && even < len) {
            while (even < len && array[even] % 2 != 0) { //找到第一个偶数even
                even++;
            }
            odd = even + 1;
            //找偶数之后的第一个奇数
            while (odd < len && array[odd] % 2 == 0) {
                odd++;
            }
            if (odd >= len) {  //注意判断，防止溢出
                break;
            }
            //把奇数取出来，从even到odd-1的元素都向后移
            int temp = array[odd];
            for (int i = odd; i > even; i--) {
                array[i] = array[i - 1];
            }
            array[even] = temp; //奇数放在原来even的位置
            even++;
        }
    }
}


/*
//方法二：对于不保证奇数和奇数，偶数和偶数之间的相对位置不变的情况
public class Title13 {
    public void reOrderArray(int[] array) {
        int L = 0;//左往右找偶数
        int R = array.length - 1;//右往左奇数
        while (L < R) {
            while (L < R && array[L] % 2 == 1) {
                L++;
            }
            while (L < R && array[R] % 2 == 0) {
                R--;
            }
            int temp = array[L];
            array[L] = array[R];
            array[R] = temp;
        }
    }
}*/
