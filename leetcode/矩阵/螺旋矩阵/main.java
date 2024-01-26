package 矩阵.螺旋矩阵;
import java.util.ArrayList;
/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 

示例 1：


输入：matrix = [[1,2,3],
               [4,5,6],
               [7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
import java.util.List;

public class main {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> list = new ArrayList<>();
        int r1 = 0;
        int r2 = m-1;
        int c1 = 0;
        int c2 = n-1;

        int times = Math.min(m,n)%2 == 1 ? Math.min(m, n)/2+1 : Math.min(m, n)/2;
        for (int j = 0; j < times; j++) {
            for (int i = c1; i <= c2; i++) {
                //
                list.add(matrix[r1][i]);
            }
            for (int i = r1+1; i <= r2; i++) {
                //
                list.add(matrix[i][c2]);
            }
            if (r1<r2 && c1<c2) {
                for (int i = c2-1; i >= c1; i--) {
                    list.add(matrix[r2][i]);
                }
                for (int i = r2-1; i > r1;i--) {
                    list.add(matrix[i][c1]);
                }
            }
            
            r1++;
            r2--;
            c1++;
            c2--;
        
        } 
        return list;
        
    }
}
