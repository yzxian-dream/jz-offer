package 全排列;
/*
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 

提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */

 import java.util.ArrayList;
//方法一深度优先搜索(回溯算法)
//编码通过 深度优先遍历 实现，使用一个列表，在 深度优先遍历 变化的过程中，遍历所有可能的列表并判断当前列表是否符合题目的要求，成为「回溯算法
import java.util.List;

public class main {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

//方法二:回溯交换
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();

//         List<Integer> output = new ArrayList<Integer>();
//         for (int num : nums) {
//             output.add(num);
//         }

//         int n = nums.length;
//         backtrack(n, output, res, 0);
//         return res;
//     }

//     public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//         // 所有数都填完了
//         if (first == n) {
//             res.add(new ArrayList<Integer>(output));
//         }
//         for (int i = first; i < n; i++) {
//             // 动态维护数组
//             Collections.swap(output, first, i);
//             // 继续递归填下一个数
//             backtrack(n, output, res, first + 1);
//             // 撤销操作
//             Collections.swap(output, first, i);
//         }
//     }
// }


















