package 数学.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/* 
 * 描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?

数据范围：
0<n≤100
进阶：时间复杂度 
O(n)

返回值描述：
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
示例1
输入：
9
复制
返回值：
[[2,3,4],[4,5]]
复制
示例2
输入：
0
复制
返回值：
[]
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param sum int整型 
     * @return int整型ArrayList<ArrayList<>>
     */
     public int[][] fileCombination(int target) {

        // write code here
        //本题可以使用滑动窗口实现，一个滑动窗口首先要定义它的左右边界。
        //假设左边界为i，右边界为j,为了编程的方便，滑动窗口一般表示成一个左闭右开区间。在一开始，i=1,j=1，滑动窗口位于序列的最左侧，窗口大小为零
        /* 
         * 对于第一个问题，回答非常简单：

当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i,j)[i, j)[i,j)，那么我们已经找到了一个 iii 开头的序列，也是唯一一个 iii 开头的序列，
接下来需要找 i+1开头的序列，所以窗口的左边界要向右移动

         */

        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target/2) {
            //要求至少包含两位数相加，所以左边界不能超过这个值，否则右边界肯定也超过，和会溢出
            if (sum < target) {
                sum += j;
                j++;
            }else if (sum > target) {
                sum -= i;
                i++;
            }else {
                int[] temp = new int[j-i];
                int index = 0;
                for (int k = i; k < j; k++) { //这里注意,j在第一个if已经加过了，多加的这个j不能要，所以k<=j不行
                    temp[index++] = k;
                }
                res.add(temp);
                //注意这两个顺序
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
