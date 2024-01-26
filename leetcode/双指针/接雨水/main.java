package 接雨水;

//首先要确定一个思路就是，去找当前列的存水情况（不要一下就想着求大面积的水量），那么当前列的存水取决于该列左右两边最高值的相对较小值，
//一位一个木桶的存水量是由最短的板高度决定的，不是最长的
//如果该值小于当前列高度，那这一列水无法存水的，如果该值大于当前列高度，那存水量就是该值减去当前列高度，最后遍历求和即可。
//先用暴力法,偶尔会超时
class Solution {
    // public int trap(int[] height) {
    //     //首尾的列肯定是存不了水的，一位他们的另一边没有值帮他们挡水。
    //     int sum = 0;
    //     for (int i = 1; i < height.length-1; i++) {
    //         int max_left= 0;
    //         for (int j = i-1; j >=0; j--) {
    //             max_left = Math.max(max_left, height[j]);
    //         }
    //         int max_right = 0;
    //         for (int j = i+1; j < height.length; j++) {
    //             max_right = Math.max(max_right, height[j]);
    //         }
    //         //这个时候已经找到了外层循环的第i列的左右两边的最大值，取相对较小值即可
    //         int min = Math.min(max_left, max_right);
    //         if (min > height[i]) {
    //             sum += min-height[i];
    //         }
    //     }
    //     return sum;
    // }
    //动态规划
    /* 
     * 特别简单，动态规划，遍历每一根柱子，考虑他左边最高的和右边最高的，取左右两根最高柱子中相对来说短的一根，
     * 用相对短的一根的高度减去这根柱子本身的高度，把所有的柱子都这样遍历一遍，求和，结果就出来了
     */
    // public int trap(int[] height) {
    //     int sum = 0;
    //     int[] max_left = new int[height.length];
    //     int[] max_right = new int[height.length];
    //     for (int i = 1; i < height.length; i++) {
    //         max_left[i] = Math.max(max_left[i-1], height[i-1]);
    //     }
    //     for (int j = height.length-2; j >= 0; j++) {
    //         max_right[j] = Math.max(max_right[j+1],height[j+1]);
    //     }
    //     for (int i = 1; i < height.length-1; i++) {
    //         int min = Math.min(max_left[i], max_right[i]);
    //         if (min > height[i]) {
    //             sum += (min-height[i]);
    //         }

    //     }
    //     return sum;

    // }

    /* 
     * 双指针法
     * 相比于动态规划创建出来的两个数组，用了一次循环把每一列的左边和右边的最高的值存储下来了。而实际上这两个数组的值也就使用了一次
     * 那么可以使用双指针进行边走边算，节省空间复杂度，时间O(n),空间O(1);效率最高
     */
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        //l_max是height[0..left]中最高柱子的高度，r_max是height[right..end]的最高柱子的高度
        //和前面解法的差异是l_max[i]和r_max[i]代表的是height[0..i]和height[i..end]的最高柱子高度。注意。
        int l_max = height[0],r_max = height[height.length-1];
        int res = 0;
        while (left <= right) {
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            //此时l_max是left左边最高的柱子，但r_max不一定是left右边最高的柱子，但是我们求该列的存水量主要是看left两边最高的相对最小
            //也就是我们只在乎min(l_max, r_max)，当l_max<r_max时，那么该列的存水量就是l_max-height[left],如果l_max就是当前列的高度
            //那么相减就是0，并没有影响。
            if (l_max < r_max) {
                res += l_max-height[left];
                //当前left列的存水量已经计算完毕，所以要移动到下一个计算
                left++;
            //这里如果l_max>r_max，则需要我们调转到right那边来按上面的思路理解，r_max是right列右边最高的柱子，l_max可能不是right列左边最高的柱子
            //不过不要紧，我们只在乎min(l_max, r_max)，那么right列的存水量就取决于相对短板的r_max,就是r_max-height[right]，
            }else{
                res += r_max-height[right];
                //当前right列的存水量已经计算完毕，所以要移动到下一个计算
                right--;
            }
        }
        return res;

    }
}

//https://www.cxyxiaowu.com/2759.html
//https://juejin.cn/post/6844904201915465741