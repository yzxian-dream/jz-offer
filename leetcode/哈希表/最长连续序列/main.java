package 哈希表.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* 
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

 

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
/* 
 * //这里的逻辑是先排序数组，在去重，最后判断前后两个数字之差是否为1，是则连续。
/* 
 * Tips:这里是使用LinkedHashcode进行去重的同时还能保证数据存放的有序性
 * HashSet
 * 1. HashSet不能有相同的元素，可以有个null元素，存入的元素是无序的
 * 2. HashSet底层是哈希表，哈希表就是存储唯一数据的表，每个数据在表中的位置是由对象的hashcode()完成
 * 3. HashSet确保唯一性的两个方法HashCode()和equas()
 * 4. 添加和删除的时间复杂度是O（1）
 * 5. 非线程安全
 * 
 * 1.LinkedHashSet中不能有相同元素，可以有一个Null元素，元素严格按照放入的顺序排列。

2.LinkedHashSet如何保证有序和唯一性？

1).底层数据结构由哈希表和链表组成。

2).链表保证了元素的有序即存储和取出一致，哈希表保证了元素的唯一性。

3.添加、删除操作时间复杂度都是O(1)。

4.非线程安全
 */
// 方法一：
public class main {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int longestStream = 1;
        for (int num : set) {

            if (!set.contains(num - 1)) {
                int curnum = num;
                int curstream = 1;
                while (set.contains(curnum + 1)) {
                    curstream++;
                    longestStream = Math.max(curstream, longestStream);
                }
            }

        }
        return longestStream;
    }
}
// 方法2
public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    Arrays.sort(nums);
    Set<Integer> set = new LinkedHashSet<>();
    for (int num : nums) {
        set.add(num);
    }
    int res = 0;
    int pre = Integer.MIN_VALUE;
    int temp = 1;
    
    for (int num : set) {
        if (num-pre == 1) {
            temp++;
        }else{
            temp=1;
        }
        pre = num;
        res = Math.max(res, temp);
    }
    return res;
}