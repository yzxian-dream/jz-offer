package 图论.腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

 

示例 1：



输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：grid = [[2,1,1],
             [0,1,1],
             [1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
示例 3：

输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2
 */
// public class main {
//     int r;
//     int c;
//     public int orangesRotting(int[][] grid) {
//         r = grid.length;
//         c = grid[0].length;
//         Queue<int[]> q = new LinkedList<>();
        
//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 if (grid[i][j] == 2) {
                    
//                 }
//                 dfs(grid[i][j],i,j);
//             }
//         }
//     }
//     public int dfs(int[][] grid,int i,int j){
//         if (i<0 || i>=r || j<0 || j>=c) {
//             return -1;
//         }
//         grid[i][j] = 2;
//         dfs(grid, i+1, j);
//         dfs(grid, i, j+1);
//         dfs(grid, i-1, j);
//         dfs(grid, i, j-1);
//     }
// }


class Solution {
    public int orangesRotting(int[][] grid) {
        // 统计新鲜橙子
        int freshNum = 0;
        // bfs 广度优先遍历 统计腐烂橙子
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshNum++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (freshNum == 0) {
                // 没有新鲜橙子了
                return minutes;
            }
            // 过去1分钟，周围开始腐烂
            minutes++;
            int size = queue.size();
            //这个for循环是保证当前相关联的腐烂的橘子这一篇全都会腐烂的橘子腐烂完，minute才会++；
            for (int i = 0; i < size; i++) {
                int[] rot = queue.pop();
                int x = rot[0];
                int y = rot[1];
                //对当前腐烂橙子的前后左右进遍历
                freshNum -= dfs(grid, x - 1, y, queue);
                freshNum -= dfs(grid, x + 1, y, queue);
                freshNum -= dfs(grid, x, y - 1, queue);
                freshNum -= dfs(grid, x, y + 1, queue);
            }
        }
        // 腐烂过程结束
        return freshNum > 0 ? -1 : minutes;
    }

    private int dfs(int[][] grid, int x, int y, Deque<int[]> queue) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 1) {
            return 0;
        }
        // grid[x][y] = 1
        grid[x][y] = 2;
        queue.offer(new int[]{x, y});
        return 1;
    }
}