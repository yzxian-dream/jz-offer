package main.java.com;
/*题目描述：

  求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
可以通过递归来实现加法，但是由于无法使用if语句，因此对于递归的结束条件无法进行判断，这里用一个比较巧妙的思路
：与运算的短路特性，所谓短路，比如 A && B，当A条件不成立时，不论B是否成立，结果都是false，所以B不再进行计算，
利用短路特性可以实现递归停止，进而求出和。
* */
public class Title47 {
    public int Sum_Solution(int n) {
        /*
        等差数列求和：S=n(n+1)/2  无法使用
        1.需利用逻辑与的短路特性实现递归终止。
        2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
	    3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
        */
        int sum=n;
        boolean ans = (n>0) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
