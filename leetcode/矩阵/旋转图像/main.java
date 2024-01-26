package 矩阵.旋转图像;
/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

 

示例 1：


输入：matrix = [[1,2,3,4],
               [5,6,7,8],
               [9,10,11,12],
               [13,14,15,16]]
输出：[[13,9,5,1],
      [14,10,6,2],
      [15,11,7,3],
      [16,12,8,4]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

提示：

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
//方法一，借助辅助矩阵进行转换，首先找出当前矩阵元素和旋转后的矩阵元素有什么联系
// matrix[i][j] = newMatrix[j][n-i-1]
// public class main {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int[][] newMatrix = new int[n][n];
//         for (int i = 0; i < newMatrix.length; i++) {
//             for (int j = 0; j < newMatrix.length; j++) {
//                 newMatrix[j][n-i-1] = matrix[i][j];
//             }
//         }

//         for (int i = 0; i < newMatrix.length; i++) {
//             for (int j = 0; j < newMatrix.length; j++) {
//                 matrix[i][j] = newMatrix[i][j];
//             }
//         }
//     }
// }


//题目要求需要原地旋转，不能借助辅助矩阵
 //https://cloud.tencent.com/developer/article/2376630?areaId=106001

 //通过方法一，我们找出了一个关系，而实际上移动90度，发生了四次替代，所谓的旋转，实际上是将每一位移动到下一个位置。
 //旋转 90° 即A[0,0]转到A[0,n]位置；A[0,n]转到A[n,n]位置；A[n,n]转到A[n,0]位置；A[n,0]转到A[0,0]位置。
 /**、
  * 上一步操作的是最外层的一层 环，我们只需要一层层往里执行相同的操作，最终即可完成整个矩阵的旋转。
 
 假设矩阵是 n*n 的，那么我们对 n/2 个环执行旋转即可完成。
 
 对于任一层的环，假设左上角索引为[i, j]，那么 j 的终止下标为 n - i - 1。
 
 重点来了，各个元素的交换的下标关系如下

A[i][j] 		由	A[n-j-1][i]		填充
A[n-j-1][i]		由	A[n-i-1][n-j-1]	填充
A[n-i-1][n-j-1]	由	A[j][n-i-1]		填充
A[j][n-i-1] 	由	A[i][j]   		填充

时间复杂度： O(n^2)。其中 n 是矩阵的边长。我们需要移动矩阵的所有元素，除了中间的那个元素。

空间复杂度： O(1)。为原地旋转。
  */
public class main {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}

/**
 * 方法三:先水平翻转，再按住对角线翻转就可达到90度翻转效果
 * matrix[row][col] 水平轴翻转 matrix[n−row−1][col]
 * matrix[row][col] 主对角线翻转 matrix[col][row]
 * matrix[row][col]水平轴翻转 matrix[n−row−1][col] 主对角线翻转 matrix[col][n−row−1]
 */

//  public class main {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         //水平翻转
//         for (int i = 0; i < n/2; i++) {
//             for (int j = 0; j < n; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[n-i-1][j];
//                 matrix[n-i-1][j] = temp; 
//             }
//         }
//         //沿对角线翻转
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
//     }
// }