package main.java.com;

import java.util.HashMap;

/*题目描述：

          请实现一个函数用来找出字符流中第一个只出现一次的字符。
        例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
        当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

          输出描述：

          如果当前字符流不存在只出现一次的字符，返回“#”字符。*/
public class Title54 {
    HashMap<Character, Integer> map = new HashMap<>();
    StringBuilder str = new StringBuilder();
    int index = 0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        str.append(ch);
        map.put(ch,map.getOrDefault(ch,0)+1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1){
                return str.charAt(i);
        }
    }
        return '#';
    }
}
