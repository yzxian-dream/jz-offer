package 数学.构建乘积数组;
/* 
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法
 * 输入: [1,2,3,4,5]

   输出: [120,60,40,30,24]
 */
//构建左侧乘积数组
//构建右侧乘积数组
//想乘即可
public class main {
    public int[] statisticalResult(int[] arrayA) {
        int[] left = new int[arrayA.length];
        int p = 1;
        for (int i = 0; i < arrayA.length; i++) {
            left[i] = p;
            p *= arrayA[i];
        }
        int[] right = new int[arrayA.length];
        int q = 1;
        for (int i = arrayA.length-1; i >= 0; i--) {
            right[i] = q;
            q *= arrayA[i];
        }
        int[] res = new int[arrayA.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }
}
