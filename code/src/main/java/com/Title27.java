package main.java.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*输入一个字符串,按字典序打印出该字符串中字符的所有排列。
   例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

  输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
对于这个问题，我们同样可以采用分解的办法。要求整个字符串的排列，可以看成两步：第一步：求所有可能出现在第一个位置的字符，
即把第一个字符与后面的字符依次交换。第二步：固定一个字符，求后面所有字符的排列。

  很明显，求后面所有字符的排列，我们仍然可以把所有的字符分成两个部分：后面的字符的第一个字符以及这个字符之后的所有字符，
然后把第一个字符逐一与其后的字符交换。因此，这是典型的递归思路。*/
public class Title27 {
    public class Solution {
        ArrayList<String> res = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            if (str == null || str.length() == 0)
                return res;
            Permutation(str.toCharArray(), 0);
            Collections.sort(res);
            return res;
        }

        public void Permutation(char[] strArr, int begin) {
            if (begin == strArr.length - 1) {
                String s = String.valueOf(strArr);
                //String.valueOf(char c) : 将 char 变量 c 转换成字符串
                //String.valueOf(char[] data) : 将 char 数组 data 转换成字符串
                if (!res.contains(s))
                    res.add(s);
            } else {
                for (int i = begin; i < strArr.length; i++) { //依次将后面的与begin交换
                    swap(strArr, begin, i);
                    Permutation(strArr, begin + 1);
                    swap(strArr, begin, i);
                }
            }
        }

        public void swap(char[] strArr, int a, int b) {
            char temp = strArr[a];
            strArr[a] = strArr[b];
            strArr[b] = temp;
        }
    }
}






