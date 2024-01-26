package 位运算.不用加减乘除做加法;

//通过位运算相加
// 5 + 7 --> 101 + 111
//1. 先计算num1和num2不进行进位的结果，101+111=010
//2. 再计算num1和num2进位的结果，101+111=1010
//3. 最后将两个相加就是结果，010 + 1010 = 1100 = 12

//
public class mian {
    public int encryptionCalculate(int num1, int num2) {
        int sum1,sum2;
        while (num2 != 0) {
            //直到不产生进位
            sum1 = num1 ^ num2;
            sum2 = (num1 & num2) << 1;
            num1 = sum1;
            num2 = sum2;
        }
        //异或就是两个数的相加的结果
        return num1;
    }
}
