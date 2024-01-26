

// class main {
//     //牛客
//     public static int strToInt(String str) {
//         int len = str.length();
//         int index = 0;
//         //第一步移动下标，删除前面的空格
//         while (index < len) {
//             if (str.charAt(index) == ' ') {
//                 index++;
//             }else{
//                 break;
//             }
//         }
//         int flag = 0; //标识正负号
//         long ans = 0; //返回最终的结果
//         boolean flag1 = false; // 3-28也是非法的，flag1标记有没有统计数字，中间的正负号直接非法了
//         while (index < len) {
//             if (!flag1 && str.charAt(index) == '+' || str.charAt(index) == '-') {
//                 if (flag != 0) {
//                     return 0;   //"-123-3",第二个-号是非法字符，返回0.
//                 }
//                 flag = str.charAt(index) == '-' ? -1 : 1;
//             }else if (str.charAt(index) > '0' && str.charAt(index) < '9') {
//                 flag1 = true;
//                 ans = ans * 10 +str.charAt(index) - '0'; //"-123"
//                 if (judge(ans,flag)){
//                     //判断当前数值是否溢出了当前范围
//                     return 0;
//                 }
         
//             }else{
//                 return 0; //既不是数字也不是+-号，那就是其他字符返回0
//             }
//             index++;
//         }
//         return flag == -1 ? (-1)*(int)ans : (int)ans; //long--->int
//     }
//     private static boolean judge(long ans, int flag) {
//         if (flag == -1) {
//             if (ans * (-1) < Integer.MIN_VALUE) {
//                 return true;
//             }
//             return false;
//         }else {
//             if (ans > Integer.MAX_VALUE) {
//                 return true;
//             }
//             return false;
//         }
        
//     }
//     public static void main(String[] args) {
//         String s1 = "2-58";
//         String s2 = "258";
//         System.out.println(strToInt(s1));

//     }
// }

/* 

 * 剑指 Offer 67. 把字符串转换成整数
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

 

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
 */

 //先找出第一个不为' '的字符，判断剩下的字符串的第一个字符是不是'-','+',，并且只能有一个，如果是在0～9，则看ans是否大于int的最大值
class Main {
    public static void main(String[] args) {
        String s1 =  "3-3";
        System.out.println(strToInt(s1));
    }
    public static int strToInt(String str) {
        int index = 0;
        int len = str.length();
        System.out.println(str.length());
        while (index < len) {
            if (str.charAt(index) == ' ') {
                index++;
            }else{
                break;
            }
        }
        int flag = 0;
        long ans = 0;
        boolean flag1 = false;
        while (index < len) {
            // System.out.println("iiiii");
            // System.out.println(index);
            // System.out.println(str.charAt(index));
            // System.out.println(flag1);
            if (!flag1 && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
                    // System.out.println("ppppppppp");
                if (flag != 0) {
                    return 0; // "+-2"确保正负号只进一次
                }
                flag = str.charAt(index) == '-' ? -1:1;
            }else if (str.charAt(index)>='0' && str.charAt(index)<='9') {
                // System.out.println("kkkkk");
                // System.out.println(str.charAt(index));
                flag1 = true;
                ans = ans * 10 + str.charAt(index)-'0';
                // System.out.println("aaaaaaaa");
                // System.out.println(ans);
                if (judge(flag ,ans)) {
          
                    if (flag == -1) {
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
            }else{
                // System.out.println("eeeee");
                // System.out.println(flag1);
                // System.out.println(index);
                if (flag1) {
                    return flag == -1 ? (-1)*(int)ans : (int)ans;
                }
                return 0;
            }
            index++;
        }
        return flag == -1 ? (-1)*(int)ans : (int)ans;
    }

    private static boolean judge(int flag, long ans) {
        if (flag < 0) {
            // System.out.println(Integer.MIN_VALUE);
            // System.out.println("judge");
            // System.out.println(ans);
            return ans * (-1) < Integer.MIN_VALUE ? true:false;
        }else{
            return ans > Integer.MAX_VALUE ? true:false;
        }
    }
}
