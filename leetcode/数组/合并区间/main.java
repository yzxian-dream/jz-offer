package 数组.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 

提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 *     public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //将所有的区间按照左端点从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

 */
public class main {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        //首先把二维数组的每一行按照左端点从小到大排序
        //匿名类写法
        // Arrays.sort(intervals,new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         // TODO Auto-generated method stub
        //         return o1[0]-o2[0]; //return回来是正数则交换o1和o2位置，返回0和-1都不交换
        //     }
        // });
        //lambda表达式写法
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        
        List<int[]> merge = new ArrayList<>();
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果是独立区间
            if (intervals[i][0]>r) {
                merge.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else{
                r = Math.max(r, intervals[i][1]);
            }
        }
        merge.add(new int[]{l,r});
        // return merge.toArray(new int[merge.size()][]);
        //这里写0也可以，推荐写0 
        /**
         * https://blog.csdn.net/weixin_42029901/article/details/103363697
         * 二维数组的第1个维度为什么可以填0？上面源码分析的第1点已经提到了，
         * 传入数组的长度小于list的元素个数size时，是默认使用size作为数组复制的长度
         */
        return merge.toArray(new int[0][]); 
    }
}
