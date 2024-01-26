package 表示数值的字符串;
/* 
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：

["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：

["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 

示例 1：

输入：s = "0"
输出：true
示例 2：

输入：s = "e"
输出：false
示例 3：

输入：s = "."
输出：false
示例 4：

输入：s = "    .1  "
输出：true
 

提示：

1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。


 */

class main {
    public static void main(String[] args) {
        String s1 = "-1E-16";
        System.out.println(isNumber(s1));
    }
    public static boolean isNumber(String s) {
        // 1.去掉空格
        s = s.trim();
        if (s.length() == 0)
            return false;
        // 2.去掉+ -
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        // 3.判断E e
        s = s.replace('E', 'e'); //注意s=s.substring给值
        if (s.indexOf('e') >= 0) {
            int idxE = s.indexOf('e');
            String left = s.substring(0, idxE);
            String right = s.substring(idxE + 1);
            if (right.length() > 0) {
                if (right.charAt(0) == '+' || right.charAt(0) == '-') {
                    right = right.substring(1);
                }
            }
            return validNumber(left) && validPureNumber(right);
        }
        return validNumber(s);
    }

    private static boolean validNumber(String s) {
        if (s.indexOf('.') >= 0) {
            int idxP = s.indexOf('.');
            String left = s.substring(0, idxP);
            String right = s.substring(idxP + 1);
            if (left.length() > 0 && right.length() > 0) {
                return validPureNumber(left) && validPureNumber(right);
            } else if (right.length() > 0) {
                return validPureNumber(right);
            } else {
                return validPureNumber(left);
            }
        }
        return validPureNumber(s);
    }

    private static boolean validPureNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
