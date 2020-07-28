package main.java.com;
/*
* 题目描述：

  我们可以用2 X 1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2 X 1的小矩形无重叠地覆盖一个2 X n的大矩形，总共有多少种方法？

  解题思路：

  我们可以以2 X 8的矩形为例。


  先把2X8的覆盖方法记为f(8)，用1X2的小矩形去覆盖时，有两种选择：横着放或者竖着放。当竖着放时，右边还剩下2X7的区域。很明显这种情况下覆盖方法为f(7)。当横着放时，1X2的矩形放在左上角，其下方区域只能也横着放一个矩形，此时右边区域值剩下2X6的区域，这种情况下覆盖方法为f(6)。所以可以得到：f(8)=f(7)+f(6)，不难看出这仍然是斐波那契数列。

  特殊情况：f(1)=1，f(2)=2*/
public class Title10 {
    public int RectCover(int target) {
        //n=1（1），n=2（2），横（n-1），竖（n-2）
        if(target<=2)
            return target;
        int first=1,second=2,res=0;
        for(int i=3;i<=target;i++){
            res=first+second;
            first=second;
            second=res;
        }
        return res;
    }
}
