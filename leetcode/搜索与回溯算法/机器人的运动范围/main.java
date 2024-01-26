package 搜索与回溯算法.机器人的运动范围;
/* 
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 */
//时间复杂度o(m*n)
public class main {
    // int[][] board;
    int m;
    int n;
    int k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        // board = new int[m][n];
        this.n = n;
        this.m = m;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0);
    }
    int dfs(int i, int j) {
        if (i < 0 || i>=m || j<0 || j>=n || visited[i][j] || getDigitsSum(i)+getDigitsSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        //在图中进行向右向下向左向上搜索，但实际上题目的不可访问的障碍物分布情况只需要向右和向下搜索就可以，所以可以优化，删除掉向左向上
        // return 1+dfs(i, j+1) + dfs(i+1, j)+ dfs( i-1, j) + dfs(i, j-1);
        return 1+dfs(i, j+1) + dfs(i+1, j);
        // visited[i][j] = false;
    
    }
    //将一个整数各个位置上的数加在一起，num/10+num%10 这种写法只适用于num<100的情况,101=1+0+1=2不是12
    int getDigitsSum(int num) {
        if(num <= 0)
            return 0;
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
