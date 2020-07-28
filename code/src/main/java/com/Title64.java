package main.java.com;
/*
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
* 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
* {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
*  {2,3,4,2,6,[2,5,1]}。
*
* n-k+1:是滑动窗口的个数，n是数组长度，k是滑动窗口大小
* */
import java.util.*;
public class Title64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        /*
        思路：用双端队列实现
        */
        ArrayList<Integer> res=new ArrayList<>();

        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<num.length;i++){
            while(!queue.isEmpty() && queue.peek()<i-size+1) //超出范围的去掉，i-size+1是第i个滑动窗口头位置数
                queue.poll();
            //当前值大于之前的值，之前的不可能是最大值，可以删掉
            while(!queue.isEmpty() && num[i]>=num[queue.getLast()])
                queue.removeLast();
            queue.add(i);
            if(i>=size-1){ //此时开始是第一个滑动窗口
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }
}
//暴力遍历法
    /*public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> ans=new ArrayList<>();
        int p1 = 0;
        int p2 = p1+size-1;
        if(num==null || num.length<1 || size<=0 || size>num.length)
            return ans;

        while(p2<(num.length)){
            int p=findmax(num,p1,p2);
            ans.add(p);
            p1++;
            p2++;
        }
        return ans;
    }
    int findmax(int[] num,int p1,int p2){
        int max=num[p1];
        for (int i=p1;i<=p2;i++)
        {
            max=(max>num[i])?max:num[i];
        }
        return max;
    }
}*/
