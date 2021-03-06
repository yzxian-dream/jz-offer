package main.java.com;
/*题目描述：变态跳台阶

  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

  解题思路：

  当只有一级台阶时，f(1)=1；当有两级台阶时，f(2)=f(2-1)+f(2-2)；一般情况下，当有n级台阶时，f(n)=f(n-1)+f(n-2)+···+f(n-n)=f(0)+f(1)+···+f(n-1)，同理，f(n-1)=f(0)+f(1)+···+f(n-2).

  因此，根据上述规律可以得到：f(n)=2*f(n-1)。这时一个递推公式，同样为了效率问题，用循环可以实现。
* */
public class Title9 {
}
