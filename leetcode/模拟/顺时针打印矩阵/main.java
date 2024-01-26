package 模拟.顺时针打印矩阵;

import java.util.ArrayList;

/* 
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。

螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。

 

示例 1：

输入：array = [[1,2,3],[8,9,4],[7,6,5]]
输出：[1,2,3,4,5,6,7,8,9]
示例 2：

输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 

限制：

0 <= array.length <= 100
0 <= array[i].length <= 100
 */
//首先确定打印圈数
public class main {
    public int[] spiralArray(int[][] array) {
        if (array.length == 0 || array[0].length == 0 || array == null) {
            return new int[0];
        }
        ArrayList<Integer> res = new ArrayList<>();
        int m = array.length; //row
        int n = array[0].length; //col
        //确定矩阵边界
        int c1 = 0;
        int c2 = n-1;
        int r1 = 0;
        int r2 = m-1;
        //确定打印圈数
        int times = Math.min(m, n)%2 == 0 ? Math.min(m, n)/2 : Math.min(m, n)/2+1;
        for (int i = 0; i < times; i++) {
            //从左上角往右上角打
            for (int c = c1; c <= c2; c++) {
                res.add(array[r1][c]);
            }
            //从右上角的下面一位往右下角打
            for (int r = r1+1; r <= r2; r++) {
                res.add(array[r][c2]);
            }
            //判断边界条件,当四条线都不相交时继续打印
            if (r1 < r2 && c1 < c2) {
                //从右下角的前一位往左下角打
                for (int c = c2-1; c > c1; c--) {
                    res.add(array[r2][c]);
                }
                //从左下角的上一位往左上角的下一位打
                for (int r = r2; r > r1; r--) {
                    res.add(array[r][c1]);
                }
            }
            //一圈打完后，移动四条线坐标
            c1++;
            c2--;
            r1++;
            r2--;
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
        //list转int[]
        //return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
