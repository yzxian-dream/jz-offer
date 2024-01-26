package 斐波那契数列;

/* 
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5


 */
/**
 * Innermain
 */

//首先想到递归
//在递归的过程中，由于有些数字会重复计算导致提交超时，比如f(8)会重复算f(3)
// public class main {
//     int[] temp;
//     public int fib(int n) {
//         temp = new int[n+1];
//         for (int i = 0; i <= n; i++) {
//             temp[i] = -1;  //用一个数组来记录f(n)有没有被计算过
//         }
        
//         return f(n);
//     }

//     int f(int n){
//         if(n<=1){
//             return n;
//         }
//         if (temp[n] != -1) {
//             return temp[n];    //当f(8)的左右两遍都有f(3)，左边f(3)已经计算保存起来了，那么算到右边直接return就行，层层往上return；
//         }
//         int sum =  (f(n-1)+f(n-2))%1000000007;
//         temp[n] = sum;
//         return sum;
//     }
// }

//第二种方法，双指针迁移法
// public class main {
//     public int fib(int n) {
//         if (n<=1) {
//             return n;
//         }
//         //找动态规律，一次都是n的前面两个数相加
//         int a = 0;
//         int b = 1;
//         int c = 0;
//         for (int i = 2; i <=n; i++) {
//             c = a + b;
//             a = b;
//             b = c;
//         }
//         return c;
//     }
// }

//动态规划dp职业写法
public class main {
    public int fib(int n) {
        //边界处理
        if (n==0) return 0;
        if (n==1) return 1;
        //初始化数组dp
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        //通过for 循环来填充dp
        for (int i = 2; i <=n; i++) {
            //找出关系式
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }
}