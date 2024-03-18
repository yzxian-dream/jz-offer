package 二维动态规划.编辑距离;
/*
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
 

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 

提示：

0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成
 */

/*
 * 我看到“方法一”三个字的时候，惊喜地以为还有方法二。。没有，这次真没有。动态规划是个好东西，但难就难在如何定义DP数组里值的含义。听我来给你捋一捋。

啥叫编辑距离？我们说word1和word2的编辑距离为X，意味着word1经过X步，变成了word2，咋变的你不用管，反正知道就需要X步，并且这是个最少的步数。

我们有word1和word2，我们定义dp[i][j]的含义为：word1的前i个字符和word2的前j个字符的编辑距离。意思就是word1的前i个字符，变成word2的前j个字符，最少需要这么多步。

例如word1 = "horse", word2 = "ros"，那么dp[3][2]=X就表示"hor"和“ro”的编辑距离，即把"hor"变成“ro”最少需要X步。

如果下标为零则表示空串，比如：dp[0][2]就表示空串""和“ro”的编辑距离

定理一：如果其中一个字符串是空串，那么编辑距离是另一个字符串的长度。比如空串“”和“ro”的编辑距离是2（做两次“插入”操作）。再比如"hor"和空串“”的编辑距离是3（做三次“删除”操作）。

定理二：当i>0,j>0时（即两个串都不空时）dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))。

啥意思呢？举个例子，word1 = "abcde", word2 = "fgh",我们现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：

知道"abcd"变成"fgh"多少步（假设X步），那么从"abcde"到"fgh"就是"abcde"->"abcd"->"fgh"。（一次删除，加X步，总共X+1步）
知道"abcde"变成“fg”多少步（假设Y步），那么从"abcde"到"fgh"就是"abcde"->"fg"->"fgh"。（先Y步，再一次添加，加X步，总共Y+1步）
知道"abcd"变成“fg”多少步（假设Z步），那么从"abcde"到"fgh"就是"abcde"->"fge"->"fgh"。（先不管最后一个字符，把前面的先变好，用了Z步，然后把最后一个字符给替换了。这里如果最后一个字符碰巧就一样，那就不用替换，省了一步）
以上三种方式算出来选最少的，就是答案。所以我们再看看定理二：

dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+int(word1[i]!=word2[j]))
dp[i-1][j]+1：情况一
dp[i][j-1]+1：情况二
dp[i-1][j-1]+int(word1[i]!=word2[j])：情况三
 */
public class main {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
         // 有一个字符串为空串
        if (n*m == 0) {
            return n+m;
        }

        int[][] dp = new int[n+1][m+1];
        // 边界状态初始化
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = dp[i-1][j]+1;
                int right = dp[i][j-1]+1;
                int left_right = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    left_right += 1;
                }
                dp[i][j] = Math.min(left,Math.min(right, left_right));
            }
        }
        return dp[n][m];
    }
}
/*
 * 时间复杂度 ：O(mn)，其中 m为 word1 的长度，n 为 word2 的长度。

空间复杂度 ：O(mn)，我们需要大小为 O(mn) 的 D 数组来记录状态值。

 */