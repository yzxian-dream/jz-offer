package 第一个只出现一次的字符;
/* 
 * 某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。

 

示例 1：

输入：arr = "abbccdeff"
输出：'a'
示例 2：

输入：arr = "ccdd"
输出：' '
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// class Solution {
//     public char firstUniqChar(String s) {
//         Map<Character,Integer> dic = new HashMap<Character,Integer>();
//         for (int i = 0; i < s.length(); i++) {
//             dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0)+1);
//         }
//         for (int i = 0; i < s.length(); i++) {
//             if (dic.get(s.charAt(i)) == 1){
//                 return s.charAt(i);
//             }
//         }
//         return ' ';
//     }
// }
//优雅
class Solution {
    public char firstUniqChar(String s) {
        char[] charAarry = s.toCharArray(); 
        Map<Character,Boolean> dic = new HashMap<Character,Boolean>();
        for (char c : charAarry) {
            Boolean res = dic.containsKey(c);
            if (res) {
                dic.put(c, false);
            }else{
                dic.put(c, true);
            }
        }
        for (char c : charAarry) {
            if(dic.get(c)){
                return c;
            }
        }
        return ' ';
    }
}