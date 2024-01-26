package 正则表达式的匹配;
/* 
 * 请设计一个程序来支持用户在文本编辑器中的模糊搜索功能。用户输入内容中可能使用到如下两种通配符：

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的那一个元素。
 

请返回用户输入内容 input 所有字符是否可以匹配原文字符串 article。

 

示例 1:

输入: input = "aa", article = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入: input = "aa", article = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入: input = "ab", article = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
public boolean test(String input,String article){
    boolean[][] dp = new boolean[input.length][article.length];
    dp[0][0] = true;
    for(int i=1;i<article.length; i++){
        if(article.charAt(i) == '*'){
            dp[0][i] = dp[0][i-1];
        }else{
            dp[0][i] = false;
        }
    }
    for(int i=1;i<input.length;i++){
        for(int j=1;j<article.length;j++){
            if(article.charAt(j-1) == '*'){
                if(article.charAt(j-2) == input.charAt(i-1) || article.charAt(j-2) == '.' ){
                    dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]
                }else{
                    dp[i][j] = dp[i][j-2];
                }
            }else{
                if(article.charAt(j-1) != input.charAt(j-1) && article.charAt(j-1) != '.'){
                    dp[i][j] = false;
                }else{
                    dp[i][j] = dp[dp[i-1][j-1];
                }
            }
        }
    }












}

public boolean test(String input,String article){
    if（input.length==0){
        return true;
    }
    int inlen = input.length;
    int alen = article.length;
    boolean[][] dp = new boolean[inlen+1][alen+1];
    dp[0][0] = true;
    dp[0][1] = false;
    for(int j=2;j<=alen;j++){
        if(article.charAt(j-1)== '*'){
            dp[0][j] = dp[0][j-2]; 
        }else{
            dp[0][j] = false;
        }
    }
    for(int i=1;i<=inlen;i++){
        for(int j=1;j<=alen;j++){
            if(article.charAt(j-1) != '*'){
                if(article.charAt(j-1) == '.' || article.charAt(j-1) == input.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = false;
                }
            }else{
                if(article.charAt(j-2) != input.charAt(i-1) && article.charAt(j-2) == '.'){
                    dp[i][j] = dp[i][j-2]
                }else{
                    dp[i][j]=dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                }
            }
        }
    }

    
}

提示：

1 <= article.length <= 20
1 <= input.length <= 20
article 只包含从 a-z 的小写字母。
input 只包含从 a-z 的小写字母，以及字符 . 和 * 。
保证每次出现字符 * 时，前面都匹配到有效的字符
 */

//动态规划三部曲
/* 
 * 1.找规律确定dp数组（dp table）以及下标的含义
2.确定递推公式
3.dp数组如何初始化, 找出初始值
4.确定遍历顺序
5.举例推导dp数组
//本体首先看两个字符串s,p
  s... intput
  p... article
  1.要判断两个字符串能否匹配，先定义dp数组，dp[i][j]表示当字符串s和p的长度为i，j时，两个字符串的匹配状态
  2.分情况确定递推公式
    - 当p[j] = '.'或p[j] = s[i]的时候==> dp[i][j] = dp[i-1][j-1]（看前面的子问题是否为true）,否则dp[i][j] = false;
    - 当p[j] = '*' 
      (1) 如果p[j-1]不等于s[i]，dp[i][j]=dp[i][j-2]
      (2) 如果p[j-1]=s[i],当*匹配0个,相当于把p的j下标和j-1下标都消除了，dp[i][j] = dp[i][j-2];
          当*匹配1个，相当于把p的j下标消除了，dp[i][j] = dp[i][j-1]
          当*匹配多个，相当于又很多个p[j-1],肯定有一个能把s[i]的值匹配上，这时候dp[i][j] = dp[i-1][j];
          这三种情况只要有一种满足，就是匹配上了，返回true，用||连接。

 */
class Solution {
    public boolean articleMatch(String s, String p) {
        // if (s == null || p == null) {
        //     return true;
        // }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //确定初始值
        dp[0][0] = true;
        // dp[0][1] = false; //默认就是false,可以不写
        //p的第一个值不会是*，不和规矩，至少从第二个开始
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*') {//s为"a",p为"a*"的时候是true
                dp[0][j] = dp[0][j-2];//注意这里的j上p的长度。
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }else{
                    if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
