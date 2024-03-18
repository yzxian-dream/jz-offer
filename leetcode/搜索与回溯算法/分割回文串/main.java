package 分割回文串;

import java.util.ArrayList;
import java.util.List;

/*
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

 

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 

提示：

1 <= s.length <= 16
s 仅由小写英文字母组成
 */
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return res;
    }
    public boolean isPalindrome(int l,int r){
        while (l<r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
    public void dfs(int i){
        if (i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i,j)) {
                list.add(s.substring(i, j+1));
                dfs(j+1);
                list.remove(list.size()-1);
            }
        }
    }
}