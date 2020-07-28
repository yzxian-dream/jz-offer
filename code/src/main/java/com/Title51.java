package main.java.com;/*
//构建乘积数组
题目描述
        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
        其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
        不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）

*/


import java.util.ArrayList;
 /*思路一：
 这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
          ,然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。
         解释下代码，设有数组大小为5。
         对于第一个for循环
         第一步：b[0] = 1;
         第二步：b[1] = b[0] * a[0] = a[0]
         第三步：b[2] = b[1] * a[1] = a[0] * a[1];
         第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
         第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
         然后对于第二个for循环
         第一步
         temp *= a[4] = a[4];
         b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
         第二步
         temp *= a[3] = a[4] * a[3];
         b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
         第三步
         temp *= a[2] = a[4] * a[3] * a[2];
         b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
         第四步
         temp *= a[1] = a[4] * a[3] * a[2] * a[1];
         b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
         由此可以看出从b[4]到b[0]均已经得到正确计算。*/

/*public class Title51 {
    public static int[] multiply(int[] A) {
      if (A == null || A.length <= 1) {
            return A;
        }
        int len = A.length;
        int[] B = new int[len];
        int[] Left = new int[len];
        int[] Right = new int[len];
        //计算左三角
        Left[0] = 1;

        for (int i = 1; i < len; i++) {
            Left[i] = Left[i-1] * A[i-1];
        }
        //计算右三角
        Right[len-1] = 1;
        for (int j = len-2; j >= 0; j--) {
            Right[j] = Right[j+1] * A[j+1];
        }
        //其中B中的元素B[i]=左三角*右三角=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
        for (int i = 0; i < len; i++) {
            B[i] = Right[i] * Left[i];
        }
        return B;
    }*/

//思路二

/*这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
 ,然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。*/

public class Title51 {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //解决左三角
        for (int i = 1; i < length; i++) {//这里完成了B[1]~B[n-1]的左三角对应相乘的部分，B[0]左三角对应相乘的部分=1不用管
            B[i] = B[i - 1] * A[i - 1];
        }
        //解决右三角
        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {//这里完成了B[0]~B[n-1]的右三角对应相乘的部分，B[n-1]右三角要乘的=1不用管
            temp *= A[j + 1];//temp始终会记录值，每次只需要加上这行上三角没有乘进来的数就可以了。
            B[j] *= temp;//把B[i]左三角部分与右三角部分相乘，其中B[n-1]在上一个for循环中已经解决，所以这里取不到也无所谓
        }
        return B;
    }

    //思路三：暴力法
/*public class Title51 {
    public static int[] multiply(int[] A) {
        if (A == null || A.length <= 1) {
            return null;
        }
    int len = A.length;
    int[] B = new int[len];

        for (int i = 0; i < len; i++) {
            int res = 1;
            for (int j = 0; j < len; j++) {
                if (j != i) {//
                    res *= A[j];
                }
            }
            B[i] = res;
            }
        return  B;
        }*/

    //测试代码
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = multiply(A);
        for (Integer i : B) {
            System.out.println(i);
        }
    }
}





