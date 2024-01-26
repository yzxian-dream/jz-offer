package 滑动窗口.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 

提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
 */
// public class main {
//     public List<Integer> findAnagrams(String s, String p) {
//         if (p.length()>s.length()) {
//             return new ArrayList<>();
//         }
//         List<Integer> list = new ArrayList<>();
//         int left = 0;
//         // int chuangkoulen = p.length();
//         // int chuangkoucount = s.length()-p.length()+1;
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < s.length()-2; i++) {
//             for (int j = i; j < i+2; j++) {
//                 sb.append(s.charAt(j));
//             }
//             if(isok(sb.toString(), p)){
//                 list.add(i);
//             }
//         }
//         return list;
//     }
//     public boolean isok (String s,String p){
//         int[] tmp = new int[26];
//         for (int i = 0; i < p.length(); i++) {
//             tmp[p.charAt(i)-'a']++;
//         }
//         for (int i = 0; i < tmp.length; i++) {
//             tmp[s.charAt(i)-'a']--;
//         }
//         for (int i : tmp) {
//             if (i != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


//时间复杂度：O(m+(n−m)×Σ)
//其中 n 为字符串 s的长度，m 为字符串 p 的长度，Σ 为所有可能的字符数。
// 我们需要 O(m)) 来统计字符串 ppp 中每种字母的数量；需要 O(m) 来初始化滑动窗口；
// 需要判断 n−m+1 个滑动窗口中每种字母的数量是否与字符串 p 中每种字母的数量相同，每次判断需要 O(Σ) 。因为 s 和 p 仅包含小写字母，所以 Σ=26。

// 空间复杂度：O(Σ)。用于存储字符串 ppp 和滑动窗口中每种字母的数量。


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //先把第一个窗口填满
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            //保证了窗口里都有值
            --sCount[s.charAt(i) - 'a'];  //把0位置对应的值抹去
            ++sCount[s.charAt(i + pLen) - 'a']; //把3位置对应的值加上，一个滑动窗口的后面一位

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}


