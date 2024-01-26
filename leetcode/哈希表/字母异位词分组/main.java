package 哈希表.字母异位词分组;
/* 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//方法1:
/* 
 *    * 本方案使用排序的方式，对数组中的每个字符串进行排序(按ascii码大小)，
     * 当两字符串使用相同单词时，排序过后两字符串则相等，利用这一点，我们将排序
     * 后字符串作为key，其内容存放在输出数组的索引作为value存入map中，当遇
     * 使用相同单词的字符串时，我们就能从map中找到相同的key存放的索引位置

 */
class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ca = s.toCharArray();
            //通过sort把字符从ASCII码从小到大排序，tea和eat都会被排成aet
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr,new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    } 
}


/* 
 *  public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
 */

































//方法2：不需要排序，用每个字符出现的次数作key
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs == null || strs.length == 0)
//             return new ArrayList<>();
//         Map<String,List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             int[] count = new int[26];
//             //char[] charArr = new char[26];
//             //这里使用每个字符出现过的次数作为key
//             for (char c : s.toCharArray()) {
//                 count[c-'a']++;//如果是char数组，++就是把当前字符进到下一个字符，比如'd'--->'e'
//             }
//             //char数组
//             // String key = String.valueOf(charArr);
//             //int数组
//             String key = Arrays.toString(count);
//             if (!map.containsKey(key)) {
//                 map.put(key, new ArrayList<>());
//             }
//             map.get(key).add(s);
//         }
//         return new ArrayList<>(map.values());
//     }
// }
