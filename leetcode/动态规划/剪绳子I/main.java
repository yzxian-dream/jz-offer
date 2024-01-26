package 剪绳子I;

/* 
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],…,k[m]。
 * 请问k[1]x…xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

输入描述：
输入一个数n(2<=n<=60)

返回值描述：
输出答案。

示例1：
输入：8
输出：18
————————————————
 */

//看到k[1]--->k[n]的题首先想到动态规划
//解题思路：
/* 
 * 找边界
 * 找规律，自底向上，确定最优子结构
 * 写出状态方程
 * 
 * 本题至少剪一刀，当绳长k=2是，res=1
 * 当k=3，第一刀可以剪下1，剩下就是3-1=2，这个2可以剪，剪刀话就回到了上一个字问题res = 1*dp[2]，不剪就是1*2=2
 * 当k=4，第一刀可以剪下1，剩下就是4-1=3，这个3可以剪，剪刀话就回到了上一个字问题res = 1*dp[3]，不剪就是1*3=3，还可剪成2*2=4
 * 所以是要比较剩余值和剪剩余值后乘积的大小，取大的
 * 
 * 1. 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
 * 2. 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2]=1
 * 3. 从第一次剪下长度为2开始剪（因为剪下的为1对乘积没有任何增益），剪了第一段j后，剩下的i-j可剪可不剪，如果不剪乘积为j(i-j),如果剪的话长度乘积为j*dp[i-j],取两者的最大值
 * 4. 第一段长度区间可取[2,i),虽所有不同的情况取最大值，dp[i]= max(dp[i],max(j*(i-j),j*dp[i-j]))
 * 
 */
public class main {
    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len+1];
        if(bamboo_len == 2){
            return 1;
        }
        // dp[2] = 1; 
        //从长度为2的绳子开始剪
        for (int i = 2; i <= bamboo_len; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[bamboo_len];

    }
}
//如下写法更符合dp
// public class main {
//     public int cuttingBamboo(int bamboo_len) {
//         int[] dp = new int[bamboo_len+1];
//         if(bamboo_len == 2){
//             return 1;
//         }
//         dp[2] = 1; 
//         //从长度为2的绳子开始剪
//         for (int i = 3; i <= bamboo_len; i++) {
//             for (int j = 1; j < i; j++) {
//                 dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
//             }
//         }
//         return dp[bamboo_len];

//     }
// }

//贪心算法
/* 

切分规则：
最优： 333 。把竹子尽可能切为多个长度为 333 的片段，留下的最后一段竹子的长度可能为 0,1,20,1,20,1,2 三种情况。
次优： 222 。若最后一段竹子长度为 222 ；则保留，不再拆为 1+11+11+1 。
最差： 111 。若最后一段竹子长度为 111 ；则应把一份 3+13 + 13+1 替换为 2+22 + 22+2，因为 2×2>3×12 \times 2 > 3 \times 12×2>3×1。

算法流程：
当 n≤3n \leq 3n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1m>1m>1 段，因此必须剪出一段长度为 111 的竹子，即返回 n−1n - 1n−1 。
当 n>3n>3n>3 时，求 nnn 除以 333 的 整数部分 aaa 和 余数部分 bbb （即 n=3a+bn = 3a + bn=3a+b ），并分为以下三种情况（设求余操作符号为 "⊙\odot⊙" ）：
当 b=0b = 0b=0 时，直接返回 3a⊙10000000073^a \odot 10000000073 
a
 ⊙1000000007；
当 b=1b = 1b=1 时，要将一个 1+31 + 31+3 转换为 2+22+22+2，因此返回 (3a−1×4)⊙1000000007(3^{a-1} \times 4)\odot 1000000007(3 
a−1
 ×4)⊙1000000007；
当 b=2b = 2b=2 时，返回 (3a×2)⊙1000000007(3^a \times 2) \odot 1000000007(3 
a
 ×2)⊙1000000007。


 * public int cuttingRope(int n) {
    if (n == 2 || n == 3)
        return n - 1;
    int res = 1;
    while (n > 4) {
        //如果n大于4，我们不停的让他减去3
        n = n - 3;
        //计算每段的乘积
        res = res * 3;
    }
    return n * res;
}


作者：sdwwld
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-fa/

————————————————
版权声明：本文为CSDN博主「此生辽阔」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/ningmengshuxiawo/article/details/113206306
 */

