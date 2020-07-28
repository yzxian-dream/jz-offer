package main.java.com;
/*
题目描述：跳台阶

  一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

  解题思路：

  首先考虑最简单的情况，如果只有1级台阶，显然只有一种跳法。如果有两级台阶，就有两种跳法：一种是分两次跳，一种是一次跳两级。

  在一般情况下，可以把n级台阶的跳法看成n的函数，记为f(n)，那么一般情况下，一开始我们有两种不同的选择：（1）第一步只跳一级，
此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即f(n-1)；（2）第一步跳两级，那么跳法数目等于后面剩下的n-2级台阶的跳法数目，
即f(n-2)。所以f(n)=f(n-1)+f(n-2)。

  至此，我们不难看出本题实际上就是求斐波那契数列，直接按照第7题思路便可以解决。
* */
public class Title8 {
    public int JumpFloor(int target) {
        if(target < 1){
            return 0;
        }if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int first = 1,second = 2,res =0;
        for (int i = 3;i <= target;i++){
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}

