package 子集;

import java.util.ArrayList;
import java.util.List;

/*
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 

提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */
//
public class main {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < 1<<n; mask++) {
            list.clear();
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
