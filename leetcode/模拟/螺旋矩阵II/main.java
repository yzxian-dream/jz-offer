package 模拟.螺旋矩阵II;

/* 
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]

#
 */
class Solution {
    public int[][] generateMatrix(int n) {
        // int r = n*n;
        int[] arr = new int[n*n];
        int[][] matrix = new int[n][n];
        if (n == 1) {
            return new int[][]{{1}};
        }
        int r1 = 0;
        int c1 = 0;
        int r2 = n-1;
        int c2 = n-1;
        for (int i = 0; i < n*n; i++) {
            arr[i] = i+1;
        }
                
        int index = 0;
        //确定需要顺时针旋转的次数，n为奇数时要加上矩阵的中心点这一层
        int times = n%2 == 0?n/2:n/2+1;
        for (int j = 0; j < times; j++) {
            for (int i = c1; i <= c2; i++) {
                matrix[r1][i] = arr[index++];
                // index++;
            }

            for (int i = r1+1; i <= r2; i++) {
                matrix[i][c2] = arr[index++];
            }
            if (c1 < c2 && r1 < r2) {
                for (int i = c2-1; i >= c1; i--) {
                matrix[r2][i] = arr[index++];
                }
                for (int i = r2-1; i > r1; i--) {
                    matrix[i][c1] = arr[index++];
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        
        return matrix;
    }

}
