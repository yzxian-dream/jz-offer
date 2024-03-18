package 杨辉三角;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。



 

示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]
 */
public class main {
    public List<List<Integer>> generate(int numRows) {
        // 初始化动态规划数组
        //这行代码创建了一个有 numRows 行的二维数组，但是还没有指定列的数量，所以每一行的长度可能会不同，这就是所谓的"不规则"或"锯齿"数组。
        Integer[][] dp = new Integer[numRows][];
        // 遍历每一行
        //这段代码将会创建一个每行长度递增的二维数组，第一行有1个元素，第二行有2个元素，以此类推，直到最后一行有 numRows 个元素。
        for (int i = 0; i < numRows; i++) {
            // 初始化当前行
            dp[i] = new Integer[i + 1];
            // 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1;
            // 计算中间元素
            for (int j = 1; j < i; j++) {
                // 中间元素等于上一行的相邻两个元素之和
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        // 将动态规划数组转换为结果列表
        List<List<Integer>> result = new ArrayList<>();
        for (Integer[] row : dp) {
            result.add(Arrays.asList(row));
        }
        // 返回结果列表
        return result;
    }
}
