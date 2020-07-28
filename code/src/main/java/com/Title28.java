package main.java.com;
//数组中出现次数超过一半的数字
/*题目描述：

          数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
          例如：输入如下所示的一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
        超过数组长度的一半，因此输出2。如果不存在则输出0。*/
import java.util.HashMap;
import java.util.Map;

public class Title28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();//存储每个数字出现的次数
        int target = 0;//用来存储出现次数最多的那个数字
        int sum = 0;//用来存储出现次数最多的那个数字的出现次数
        for (int x:array){
            map.put(x,map.getOrDefault(x,0)+1);//跟新当前位置数字出现的次数
            if (sum < map.get(x)){//说明当前位置的数字出现的次数比之前统计的target数字出现的次数大
                sum = map.get(x);
                target = x;
            }
        }
        if (sum > array.length/2){
            return target;
        }
        return 0;
    }
}

