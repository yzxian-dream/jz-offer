package 矩阵.矩阵置0;
/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

 

示例 1：


输入：matrix = [[1,1,1],
              [1,0,1],
              [1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
示例 2：


输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

 //方法一定义两个数组来标记哪一行或那一列出现了0，在循环遍历，把出现的行列全部置0
 //时间复杂度：O(mn),空间复杂度（m+n）
// public class main {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         boolean[] rowindex = new boolean[m];
//         boolean[] colindex = new boolean[n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     rowindex[i] = true;
//                     colindex[j] = true;
//                 }
//             }
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (rowindex[i] || colindex[j]) {
//                     matrix[i][j] = 0;
//                 }
//             }
            
//         }
//     }
// }

//方法二，不使用数组，直接使用标记变量的话就可以使空间复杂度O(1)
//第一行第一列已经包含了所有的行列，所以可以用来标记，省去数组


public class main {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagrow0 = false, flagcol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagcol0 = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i]==0) {
                flagrow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagcol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagrow0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        123
        456
        789
    }
}