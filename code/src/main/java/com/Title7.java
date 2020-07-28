package main.java.com;
/*题目描述：

  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。假设n<=39。

  解题思路：

  斐波那契数列：0,1,1,2,3,5,8........ 总结起来就是：第一项是0，第二项是1，后续第n项为第n-1项和第n-2项之和。
f(n)=0  (n=0);
f(n)=1   (n=1);
f(n)=f(n-1)+f(n-2); (n>1);

  用公式描述如下：*/
public class Title7 {
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        //return Fibonacci(n-1)+Fibonacci(n-2); //递归只需要这一句
        int first=0,second=1,res=0;
        for(int i=2;i<=n;i++){
            res=first+second;
            first=second;
            second=res;
        }
        return res;
    }
}
