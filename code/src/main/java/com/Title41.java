package main.java.com;
/*题目描述：

  小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

  输出描述：

  输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序。

  解题思路：

  对于本题，由于是在一个连续序列中连续查找，可以使用类似滑动窗口的思想，使用双指针定位滑动窗口的上下边界，
用两个数low和high分别指向当前序列中的最大和最小值，初始low为1，high为2。如果从low到high的序列的和大于给定的S，
那么说明可以去掉一个比较小的值，即增大low的值（相当于去掉了一个最小值，窗口收缩）。反之，如果从low到high的序列和小于给定的S，
则应该增加一个值，即增大high（相当于窗口扩张，让这个窗口包含更多的值）。这样依次查找就可以找到所有的满足条件的序列，
并且符合序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序要求。

  另外，需要注意的是：循环的结束条件。由于要求序列至少包含两个数，因此当low追上high或者当low超过S的一半时，即可停止查找。
* */
import java.util.ArrayList;
import java.util.List;

public class Title41 {
    /*public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
            }

            while (curSum > sum ) {
                curSum -= small;
                small++;

                if (curSum == sum) {
                    List<Integer> list = new ArrayList<>(2);
                    for (int i = small; i <= big; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }
            }

            big++;
            curSum += big;
        }

        return result;
    }
}
*/
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        //思路：双指针滑动窗口
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int low=1,high=2; //窗口的初始指针
        int curSum=low+high; //当前窗口中元素之和
        while(low<high && low<(sum+1)/2){ //至少连个元素，左指针追上右指针，或者左指针超过一半停止
            if(curSum==sum){ //相等，说明找到一个序列
                ArrayList<Integer> temp=new ArrayList<>();
                for(int i=low;i<=high;i++) {
                    temp.add(i);
                }
                res.add(temp);
                curSum -= low;
                ++low;
            }
            else if(curSum>sum){ //当前和大于sum，左指针右移，减去一个小值
                curSum -= low;
                ++low;
            }else{ //当前和小于sum，右指针右移，加上一个值
                ++high;//前后顺序不能换
                curSum += high;
            }
        }
        return res;
    }
}


