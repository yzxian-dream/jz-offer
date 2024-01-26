package 股票的最大利润;

/* 
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

 //dp[i] = 

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 

限制：

0 <= 数组长度 <= 10^5


 */
//暴力求解，找出后面的数与前面的数的最大差值
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxlirun = 0;
//         for (int i = 0; i < prices.length-1; i++) {
//             // int minmr = prices[i];
//             for (int j = i+1; j < prices.length; j++) {
//                 if (prices[j]-prices[i] > maxlirun) {
//                     maxlirun = prices[j]-prices[i];
//                 }
//             }
//         }
//         return maxlirun;
//     }
// }

//动态规划

//思路：首先这个动态规划，和之前不同，不是一个个积累，而是单个点的实时变化。
class Solution {
    public int maxProfit(int[] prices) {
        //如果交易日为0天，没得交易，利润为0；
        //如果交易日为1天，只能当天买当天卖，利润为0；
        if (prices.length<2) {
            return 0;
        }
        //初始化动态数组，用来存放每天的最大利润
        //构建一个数组，dp[i]表示以price[i]为结尾的最大利润，price[i]表示股票在第i天的价格
        int[] dp = new int[prices.length];
        dp[0] = 0;
        //先初始化一个最小买入点，假设在第0天买入的值最小
        int buy = prices[0];
        

        
        for (int i = 1; i < dp.length; i++) {
          
            //假设在第一天卖出，sell表示当天卖出的价格
            int sell = prices[i];
            //利润
            int profit = sell - buy;
            //每次对比的是前i-1日的最大利润和第i日减去第i日价格减去前i-1日的最低价格
            //保存最大利润到dp[i]
            dp[i] = Math.max(profit, dp[i-1]);
            //跟新buy,让其为当前区间的最小值，这样来保证profit尽可能大
            buy = Math.min(prices[i],buy);
        }
        return dp[prices.length-1];
    }
}