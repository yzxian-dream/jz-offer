package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 

提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class main {

  
 List<String> result = new ArrayList<>();
 StringBuilder temp = new StringBuilder();
 Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {
        {
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTracking(digits, 0);
        return result;
    }
    
    private void backTracking(String digits, int num) {
        if (digits.length() == num) {
            result.add(temp.toString());
            return;
        }

        List<Character> list = map.get(digits.charAt(num));
        if (list == null) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Character cur = list.get(i);
            temp.append(cur);
            backTracking(digits, num + 1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    

}
