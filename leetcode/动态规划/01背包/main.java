package 01背包;
/*
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
输入示例
6 1
2 2 3 1 5 2
2 3 1 5 4 3


	  重量	价值
物品0	1	15
物品1	3	20
物品2	4	30
 */

 /*
  * 依然动规五部曲分析一波。

1.确定dp数组以及下标的含义
对于背包问题，有一种写法， 是使用二维数组，即dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。

2.确定递推公式
再回顾一下dp[i][j]的含义：从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少

3.dp数组如何初始化
首先从dp[i][j]的定义出发，如果背包容量j为0的话，即dp[i][0]，无论是选取哪些物品，背包价值总和一定为0

4.确定遍历顺序
在如下图中，可以看出，有两个遍历的维度：物品与背包重量
  */


public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    /**
     * 初始化 dp 数组做了简化(给物品增加冗余维)。这样初始化dp数组，默认全为0即可。
     * dp[i][j] 表示从下标为[0 - i-1]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
     * 其实是模仿背包重量从 0 开始，背包容量 j 为 0 的话，即dp[i][0]，无论是选取哪些物品，背包价值总和一定为 0。
     * 可选物品也可以从无开始，也就是没有物品可选，即dp[0][j]，这样无论背包容量为多少，背包价值总和一定为 0。
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods + 1][bagSize + 1];  // 给物品增加冗余维，i = 0 表示没有物品可选
        // 初始化dp数组
        //可以省去这两步初始化。，默认就是0，动态规划从1开始即可
        // for(int i=0; i<=goods; i++) {
        //     dp[i][0] = 0;
        // }
        // 正序遍历
        // for (int j = weight[0]; j <= bagweight; j++) {
        //     dp[0][j] = value[0];
        // }

        // 初始化dp数组，默认全为0即可
        // 填充dp数组
        for (int i = 1; i <= goods; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i - 1]) {  // i - 1 对应物品 i
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - weight[i - 1]] + value[i - 1]);  // i - 1 对应物品 i
                }
            }
        }

        // 打印dp数组
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
    }
}
