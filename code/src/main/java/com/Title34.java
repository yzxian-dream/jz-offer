package main.java.com;

import java.util.HashMap;
import java.util.Map;

/*题目描述：

          在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
        并返回它的位置, 如果没有则返回 -1（需要区分大小写）。

          解题思路：

          对于本题，这里给出以下三种解法：（1）用 HashMap 建立每个字符与其出现次数的映射，
        然后再依次遍历字符串时，找到第一个出现次数为1的字符，返回其位置即可。
        （2）更进一步，因为该字符串全部是字母，所以可以用一个数组代替哈希表，数组下标就代表该字母。
        （3）使用模式匹配从前（indexOf）和从后（lastIndexOf）匹配每一个字符，相等即为唯一。*/
public class Title34 {
    public int FirstNotRepeatingChar(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] strArr = s.toCharArray();
        //for(int i=0;i<strArr.length;i++){
       //for (int i = 0; i < s.length() ; i++)

        for(char x : strArr){
            // char c=s.charAt(i);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int j=0;j<s.length();j++){
            if(map.get(s.charAt(j))==1)
                return j;
        }
        return -1;
    }
}

