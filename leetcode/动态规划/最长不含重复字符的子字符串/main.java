package 最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;
/* 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 dp[i] = dp[i-1]+1

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

s.length <= 40000
 */
//思路1 滑动窗口，跟换做指针到重复数字的下一个位置
// class main {
//     public static void main(String[] args) {
//         String s = "au";
//         System.out.println(lengthOfLongestSubstring(s));

//     }
//     public static int lengthOfLongestSubstring(String s) {
//         Map<Character,Integer> map = new HashMap<>();
//         if (s.length() == 0) {
//             return 0;
//         }
//         if (s.length() == 1) {
//             return 1;
//         }
//         int left = 0;
//         // int right = 0;
//         int res = 1;
//         int len = s.length();
//         map.put(s.charAt(0), 0);
//         for (int right = 1; right < len; right++) {
//             if(map.containsKey(s.charAt(right))){
//                 System.out.println("asdasdas");
//                 int k = map.get(s.charAt(right));
//                 left = Math.max(left, k+1);
//             }
//             System.out.println(right);
//             System.out.println(right-left+1);
//             res = Math.max(res, right-left+1);
//             System.out.println(res);
//             map.put(s.charAt(right), right);
//         }
//         return res;
//     }
// }
//高频题
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //以字符s[i]结尾时，不重复子串长度为dp[i]
        //如果s[i]在dp[i-1]区间没出现过，那dp[i] = dp[i-1]+1
        //反之，dp[i] = i-k，k表示dp[i-1]区间第一个位置
        if (s == null || s.length()==0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        //new 一个hashMap来保存s[i]和i，用来跟新最新值和下标；
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                //如果s[i]没有在hash表里出现过，dp[i]就是dp[i-1]+1,
                dp[i] = dp[i-1] + 1;
            }else{
                int k = map.get(s.charAt(i));
                //dp[i-1]默认就是已经存好的连续不重复的长度了
                //否则s[i]出现过，如果在dp[i-1]区间内出现过,那i-k必然<=dp[i-1]，那dp[i] = i-k,
                //否则s[i]没在dp[i-1]区间出现过，dp[i]就是dp[i-1]+1,
                dp[i] = i-k>dp[i-1] ? dp[i-1]+1 : i-k;

            }
            map.put(s.charAt(i), i);
            res = Math.max(res, dp[i]);

        }
        return res;
    }
}
