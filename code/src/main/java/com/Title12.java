package main.java.com;
/*题目描述：数值的整数次方

  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

  解题思路：

  本题看似比较简单，是一个简单的指数运算，但需要完整的考虑到所有情况。首先，对于底数，如果底数为0，则0的任何次方都是0，可以直接返回0。关键在于指数，指数可能有三种情况，有可能是正数、0、负数。对于指数是0的情况，任何数的0次方为1。对于指数是负数的情况，可以将其转化为绝对值计算，求出结果之后再求倒数。

  在计算n次方的时候，为了方便，我们根据减治的思想，通过同底数指数幂的公式计算，如下列公式。这里需要注意的是奇数和偶数的不同。
* */
public class Title12 {
    public double Power(double base, int exponent) {
        //除2计算
        if(exponent==0)
            return 1.0;
        if(exponent==1)
            return base;
        if(exponent==-1)
            return 1.0/base;
        double half=Power(base,exponent/2); //一半
        return half*half*Power(base,exponent%2); //注意奇偶不同，奇数多乘一个base
    }
}
