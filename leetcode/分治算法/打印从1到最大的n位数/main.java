package 分治算法.打印从1到最大的n位数;
/* 
 * 描述
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
1. 用返回一个整数列表来代替打印
2. n 为正整数，0 < n <= 5
示例1
输入：
1
复制
返回值：
[1,2,3,4,5,6,7,8,9]
 */

class Solution {
    public int[] countNumbers(int cnt) {
        int max = (int)Math.pow(10, cnt);
        int[] res = new int[max-1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i+1;
        }
        return res;
    }
}