package 分治算法.数值的整数次方;
/* 
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

 

示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
 

提示：

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */
//采用快速幂思想
class Solution {
    public double myPow(double x, int n) {
        long y = n;
        if(n < 0){
            y = (-1)*y;
            x = 1 / x;
        }
        double res = 1;
        while(y > 0){
            if(y % 2 == 1){
                res *= x;
            }
            x *= x;
            y /= 2;
        }
        return res;
    }
}