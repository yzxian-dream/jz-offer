package main.java.com;
/*数组中的重复数字*/
/*
题目描述
        在一个长度为n的数组里的所有数字都在0到n-1的范围内。
        数组中某些数字是重复的，但不知道有几个数字是重复的。
        也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
        例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/
//先说一下底下的duplicate方法大意，boolean：判断数组中某个数出现次数是否大于1次，true or flase
//传入数组，长度，以及duplication数组，把某个重复的数返回到duplication[0]中。
/*解法	解法介绍	是否改变原数组	时间复杂度	空间复杂度
        解法一	暴力求解	否	o(n^2)	o(1)
        解法二	借助快排	是	o(nlogn)	o(1)
        解法三	借助哈希表	否	o(n)	o(n)
        解法四	根据数字特点排序	是	o(n)	o(1)
        解法五	二路计数	否	o(nlogn)	o(1)*/


//思路一：也是最优解，根据数字特点排序

/*
1. 分析
数组的长度为 n 且所有数字都在 0 到 n-1 的范围内，我们可以将每次遇到的数进行"归位"，当某个数发现自己的"位置"被相同的数占了，则出现重复。
扫描整个数组，当扫描到下标为 i 的数字时，首先比较该数字（m）是否等于 i，如果是，则接着扫描下一个数字；如果不是，则拿 m 与第 m 个数比较。如果 m 与第 m 个数相等，则说明出现重复了；如果 m 与第 m 个数不相等，则将 m 与第 m 个数交换，将 m "归位"，再重复比较交换的过程，直到发现重复的数

2.举个栗子：
以数组 {2,3,1,0,2,5,3} 为例
当 i = 0 时，nums[i] = 2 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{1,3,2,0,2,5,3}
此时 i = 0，nums[i] = 1 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{3,1,2,0,2,5,3}
此时 i = 0，nums[i] = 3 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{0,1,2,3,2,5,3}
此时 i = 0，nums[i] = 0 = i，继续下一组
当 i = 1，nums[i] = 1 = i，继续下一组
当 i = 2，nums[i] = 2 = i，继续下一组
当 i = 3，nums[i] = 3 = i，继续下一组
当 i = 4，nums[i] = 2 != i，判断 nums[i] 等于 nums[nums[i]]，出现重复，赋值返回*/

import java.util.Arrays;

//3. 复杂度
 //     时间复杂度：O(n)
 //     空间复杂度：O(1)
public class Title50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {//边界条件
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {//遍历数组
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {//所有数字都在0到n-1的范围内。
                return false;
            }
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}


/*
思路二：排序在比较
        1. 分析
        将输入数组排序，再判断相邻位置是否存在相同数字，如果存在，对 duplication 赋值返回，否则继续比较
        时间复杂度：O(nlogn)
        空间复杂度：O(1)*/


    /*public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0){
            return false;
        }
        Arrays.sort(numbers);



        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}*/