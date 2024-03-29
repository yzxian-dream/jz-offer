package 位运算.二进制中1的个数;


/* 
解法1
对于左移，右移，大多数人都知道下面两点
左移将原数乘以2
右移将原数除以2
下面先来展示上面两点
原数： 100
整型是4字节32位，将100以整型的二进制表示
二进制： 00000000 00000000 00000000 01100100

100 >> 2
二进制： 00000000 00000000 00000000 00011001 | 00
解释： | 后面被剔除，前面缺少的两个补0
结果： 25
右移两位相当于除以2，再除以2，结果为25

100 << 2
二进制： 00 | 00000000 00000000 00000001 100100 00
解释： | 前面被剔除，后面缺少的两个补0
结果： 400
左移两位相当于乘以2，再乘以2，结果为400


解法2 
 * 有个优化特征，n&（n-1）的结果恰为把n的二进制位中的最低位的1变成0之后的结果
 * 这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 n与n-1 做与运算，
 * 直到 nnn 变为 000 即可。因为每次运算会使得 n 的最低位的 111 被翻转，因此运算次数就等于 n 的二进制位中 111 的个数

 */
// public class main {
//        // you need to treat n as an unsigned value
//     public int hammingWeight(int n) {
//         int sum = 0;
//         while (n != 0){      
//             sum += n&1;
//             n >>>= 1; //无符号右移，忽略符号位，空位都以0补齐        
//         }
//         return sum;
//     }
// }


public class main {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n-1);
            sum++;
        }
        return sum;
    }
}