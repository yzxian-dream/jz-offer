package 替换空格;
//空复 O（n）
/* 
 * 
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000


 */
// public class main {
//     public String replaceSpace(String s) {
//         StringBuilder res = new StringBuilder();
//         char[] charArrry = s.toCharArray();
//         for (char c : charArrry) {
//             res.append(c == ' ' ? "%20":c);
//         }
//         return res.toString();
//     }
// }

//原地扩容
// public class main {
//     class Solution {
//         public String replaceSpace(String s) {
//             int count = 0;
//             for (int i = 0; i < s.length(); i++) {
//                 if (s.charAt(i) == ' ') {
//                     count++;
//                 }

//             }
//             char[] res = new char[count * 2 + s.length()];
//             int k = 0;
//             for (int i = 0; i < s.length(); i++) {
//                 if (s.charAt(i) == ' ') {
//                     res[k++] = '%';
//                     res[k++] = '2';
//                     res[k++] = '0';

//                 } else {
//                     res[k++] = s.charAt(i);
//                 }

//             }
//             return new String(res);
//         }
//     }
// }


