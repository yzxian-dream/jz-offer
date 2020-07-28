package main.java.com;
//2.替换空格
//题目描述
// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

// 思路
// 那我首先想到的是使用额外空间的解法，使用StringBuffer字符串缓冲区，或StringBuider
// 首先遍历target目标字符串，且在遍历的同时将不是空格的字符append到StringBuffer，
//当匹配到空格则append（"%20"）。
/*
import java.util.Scanner;
public class Title2 {
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();//String是无法扩容的，而StringBuilder是可以的
        int len = str.length();
        String res = "%20";//这里注意要求
        for(int i=0;i<len;i++){
            sb.append(str.charAt(i) == ' ' ? res:str.charAt(i));
            */
/*if(str.charAt(i) == ' '){//是charAt()不是charAt[]
                sb.append(res);
            }else{
                sb.append(str.charAt(i));//获取字符串索引处对应的单个字符
            }*//*

        }
        return sb.toString();
    }


//测试代码
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();//next读不到空格，读到空格就停止，而nextLine是读取每一行的字符串，都读取
        StringBuffer str = new StringBuffer();
        str.append(s);
        System.out.println(replaceSpace(str));
    }
}
*/
//
//方法二：快慢（双指针）指针解决字符串替换问题
public class Title2 {
    public String replaceSpace(StringBuffer str) {
        int blankNumber = 0;//空格数目
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                blankNumber++;
            }
        }
        int newLength = str.length() + 2 * blankNumber;//新字符（替换完之后的）序列长度
        int oldIndex = str.length() - 1;//从尾往头找
        int newIndex = newLength - 1;
        str.setLength(newLength);//在原字符串序列基础上增加长度，增加到替换完后总长度

        while (newIndex > oldIndex && oldIndex >= 0) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();
    }
}
