package 贪心算法.划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class main {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //这个数组用于记录每个字母出现的最后位置
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            /**
             * 这里使用官解中的例子来说明end的选择
             * s = "ababcbacadefegdehijhklij"
             * 在这个例子中，划分结果为："ababcbaca"、"defegde"、"hijhklij"
             * end用于标记子串的末尾，那么一个子串中就包含固定的几种字母，而last数组是用来记录每个字母出现的最后位置
             * 因此可以在子串中去寻找最大的end值，找到最大的end值后，i没有遍历到下一个子串前不会再有更大的end值
             * 例如: a的end为9，b的end位6，c的end位8，一直遍历到i==9时，记录子串长度然后寻找下一个子串即可
             */
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
