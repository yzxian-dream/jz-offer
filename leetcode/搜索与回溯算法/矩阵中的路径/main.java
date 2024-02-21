package 搜索与回溯算法.矩阵中的路径;
/* 
单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；
 * 否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

 

例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 

提示：

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成
 */


public class main {
    int n;
    int m;
    int len;
    boolean[][] visited;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.len = word.length();
        this.board =board;
        visited = new boolean[n][m];
        //通过两层嵌套遍历，覆盖所有情况
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                //以该元素为起点，递归检查是否符合要求,k用来记录符合条件的字符长度
                if (dfs(i,j,word,0)) {
                    return true;
                }
            }
      
        }
        return false;
    }

    boolean dfs(int i, int j, String word, int k) {
        if (i>=n || i<0 || j<0 || j>=m || board[i][j] != word.charAt(k)) {
            return false;
        }
        //在递归的过程中，没被上面的false return掉，说明之前已经和目标字符串匹配成功了length-1个字符，此时又匹配成功了最后一个字符，直接返回结果
        if (k == len-1) {
            return true;
        }
        // visited[i][j] = true;
        //标记当前矩阵元素，修改为特殊字符#，不使用visited数组，可以降低空间复杂度。
        //代表此元素已经被访问过，防止之后搜索重复访问
        board[i][j] = '#';
        boolean res = dfs( i, j+1, word, k+1)
        || dfs(i+1, j, word, k+1) 
        || dfs(i, j-1, word, k+1)
        || dfs( i-1, j, word, k+1);
        //回溯时还原当前矩阵元素
        board[i][j] = word.charAt(k);
        // visited[i][j] = false;
        return res;

    }
}
