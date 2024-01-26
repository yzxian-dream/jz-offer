package 哈希表.两个数组的交集;

import java.util.HashSet;
import java.util.Set;

public class main {
    public int[] intersection(int[] nums1,int[] nums2){
        if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int element : nums2) {
            if (set1.contains(element)) {
                set2.add(element);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for(int i : set2){
            res[index++] = i;
        }
        return res;
    }
}
