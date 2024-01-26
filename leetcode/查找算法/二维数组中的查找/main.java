package 二维数组中的查找;
/* 
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
//暴力 时间复杂度O(nm)
// class Solution {
//     public boolean findNumberIn2DArray(int[][] matrix, int target) {
//         if (matrix.length == 0) {
//             return false;
//         }
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == target) {
//                     return true;
//                 }
//                 if (matrix[i][j] > target) {
//                     break;
//                 }
//             }
//         }
//         return false;
//     }
// }

//对于这个二维数组，从左下角看，单列往上越来越小，单行往右越来越大
//可以采用二分法

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        //定义左下角数字
        int l = matrix.length-1;  //行
        int r = 0;   //列
        while (l>=0 && r<matrix[0].length) {
            if (matrix[l][r] > target) {
                l--;
            }else if(matrix[l][r] < target){
                r++;
            }else{
                return true;
            }
        }
        return false;
    }
}
   
