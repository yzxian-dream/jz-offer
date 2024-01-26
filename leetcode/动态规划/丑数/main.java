package 丑数;
/* 
给你一个整数 n ，请你找出并返回第 n 个 丑数 。

说明：丑数是只包含质因数 2、3 和/或 5 的正整数；1 是丑数。


示例 1：

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
提示： 

1 <= n <= 1690
 * 
 */
class Solution {
    public int nthUglyNumber(int n) {
        //先确定dp,dp[i]表示第i个丑数
        //dp[i]=min(dp[a]*2, dp[b]*3, d[c]*5)
        int a=1,b=1,c = 1;//定义三个基数，乘因子
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(Math.min(dp[a]*2, dp[b]*3), dp[c]*5);
            if (dp[i] == dp[a]*2) a++; //使用该丑数后，当前下标要移动到下一个丑数。
            if (dp[i] == dp[b]*3) b++;
            if (dp[i] == dp[c]*5) c++;
        }
        return dp[n];
        
    }
}
