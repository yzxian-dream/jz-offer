package 排序算法.扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return bool布尔型
     */
    public boolean IsContinuous (int[] numbers) {
        // write code here
        if (numbers.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : numbers) {
            if (i == 0) {
                sum++;
            }
        }
        Arrays.sort(numbers);
        for (int i = sum+1; i < numbers.length; i++) {
            sum-=numbers[i]-numbers[i-1]-1;
            if (sum < 0 || numbers[i] == numbers[i-1]) {
                return false;
            }
        }
        return true;
    }
}
