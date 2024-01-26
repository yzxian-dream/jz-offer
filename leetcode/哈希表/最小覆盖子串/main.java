package 哈希表.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
 

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。
 

提示：

m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成
 */

 /**
  * /**
 * 两个指针都index为0出发，一个用于延伸现有窗口的r指针，和一个用于收缩窗口的l指针，在任意时刻只有一个指针运动，而另一个保持静止
 * 我们在s上滑动窗口，通过移动r指针不断扩张窗口。当窗口包含t全部所需的字符后，如果能收缩，就移动右移l指针进行收缩，我们就是收缩窗口直到得到最小值、
 * 在移动窗口的过程中要记录满足条件的起始位置l，和窗口的长度length=r-l
 */
/**
 * 
 * 滑动窗口的模版
 * 
 * 固定窗口大小
1. 对于固定窗口，我们只需要固定初始化左右指针 l 和 r，分别表示的窗口的左右顶点，并且保证：
l 初始化为 0
初始化 r，使得 r - l + 1 等于窗口大小
同时移动 l 和 r
判断窗口内的连续元素是否满足题目限定的条件
    4.1 如果满足，再判断是否需要更新最优解，如果需要则更新最优解
    4.2 如果不满足，则继续。


2.对于可变窗口，我们同样固定初始化左右指针 l 和 r，分别表示的窗口的左右顶点。后面有所不同，我们需要保证：
l 和 r 都初始化为 0
r 指针移动一步
判断窗口内的连续元素是否满足题目限定的条件
    3.1 如果满足，再判断是否需要更新最优解，如果需要则更新最优解。并尝试通过移动 l 指针缩小窗口大小。循环执行 3.1
    3.2 如果不满足，则继续。
形象地来看的话，就是 r 指针不停向右移动，l 指针仅仅在窗口满足条件之后才会移动，起到窗口收缩的效果。
 */
// @lc code=start
//这种一下就应该想到滑动窗口，滑动窗口的本质实际上就是双指针（可以叫快慢指针，也可以叫左右指针），
public class main {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()) {
            return "";
        }
        //用于记录滑动窗口内有效字符
        Map<Character,Integer> window = new HashMap<>();
        //用于记录字符串t的所有字符，也就是有效字符
        Map<Character,Integer> needChar = new HashMap<>();
        //定义左右指针
        int l=0,r=0;
        //定义一个变量来记录窗口里有效字符与t里的有效字符的匹配个数
        int match = 0;
        //定义满足条件的滑动窗口的起始下标和长度
        int start = 0,len = Integer.MAX_VALUE;
        //先把t里的字符全都落map.
        for (int i = 0; i < t.length(); i++) {
            needChar.put(t.charAt(i),needChar.getOrDefault(t.charAt(i), 0)+1);
        }
        //开始滑动窗口模版，进行无固定滑动窗口流程
        while (r<s.length()) {
            //右指针从第一位开始延伸窗口
            //当第一位的值就是有效字符
            if (needChar.containsKey(s.charAt(r))) {
                //把这个有效字符装入滑动窗口的map
                window.put(s.charAt(r),window.getOrDefault(s.charAt(r), 0)+1);
                //在循环的过程中如果发现滑动窗口内的有效字符的个数=t里的有效字符的个数，表示有一个已经匹配上了，match++记录；
                if (window.get(s.charAt(r)).equals(needChar.get(s.charAt(r)))) {
                    match++;
                }
            }
            //移动右指针延伸窗口
            r++;
            //当匹配的个数和t里的字符数相同时，这里用size是对的，match记录的是把needchar里的key匹配完才会加1，比如'a':2,上面只有进两个if，match才会+1；
            //开始缩减窗口
            while (match == needChar.size()) {
                //如果当前的子串小于已经统计到的子串的值
                if (r - l < len) {
                    start = l;
                    len = r-l;
                }
                if (needChar.containsKey(s.charAt(l))) {
                    
                    if (window.get(s.charAt(l)).equals(needChar.get(s.charAt(l)))) {
                        match--;
                    }
                    window.put(s.charAt(l), window.get(s.charAt(l))-1);
                }
                //一只相等就一直缩减窗口
                l++;
            }
        }
        //这里要判断一下
        return len == Integer.MAX_VALUE ? "":s.substring(start, start+len);

    }
}
