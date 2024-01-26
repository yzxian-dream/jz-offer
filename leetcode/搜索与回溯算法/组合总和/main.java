package 组合总和;

import java.util.ArrayList;
import java.util.List;

/* 
 * 组合总和
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。

解集不能包含重复的组合。

示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
1
2
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class main {
    public List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> list,int k,int start,int n){
        if (list.size() == k || n <= 0) {
            //如果找到一组合适的就把他加入到集合list中
            if (list.size() == k && n == 0)
                res.add(new ArrayList<>(list));
            return;
        }
         //通过循环，分别遍历9个子树
        for (int i = start; i < 10; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i+1, n-i);
            //撤销选择
            list.remove(list.size()-1);
        }
    }
}


 /* 

 ，代码dfs中最开始的地方是终止条件的判断，递归必须要有终止条件。

2，下面的for循环分别遍历他的 9 个子节点，注意这里的i是从start开始的，所以有可能还没有9个子树，前面说过，如果从 9 个数字中选择一个之后，第2次就只能从剩下的 8 个选择了，第3次就只能从剩下的7个中选择了……

3，在第20行dsf中的start是i+1，这里要说一下为什么是i+1。比如我选择了3，下次就应该从4开始选择，如果不加1，下次还从3开始就出现了数字重复，明显与题中的要求不符

4，for循环的i为什么不能每次都从1开始，如果每次都从1开始就会出现结果重复，比如选择了[1，2]，下次可能就会选择[2，1]。

5，如果对回溯算法不懂的，可能最不容易理解的就是最后一行，为什么要撤销选择。因为会出现分支污染问题，因为list是引用传递，当从一个分支跳到另一个分支的时候，如果不把前一个分支的数据给移除掉，那么list就会把前一个分支的数据带到下一个分支去，造成结果错误。

要搞懂最后一行代码首先要明白什么是递归，递归分为递和归两部分，递就是往下传递，归就是往回走。递归你从什么地方调用最终还会回到什么地方去，我们来画个简单的图看一下
------------------------------------------
  * 总结
     1
 2   4   9

这是一棵非常简单的3叉树，假如要对他进行DFS遍历，当沿着1→2这条路径走下去的时候，list中应该是[1，2]。

因为是递归调用最终还会回到节点1，如果不把2给移除掉，当沿着1→4这个分支走下去的时候就变成[1，2，4]，但实际上1→4这个分支的结果应该是[1，4]，这是因为我们把前一个分支的值给带过来了。

当1，2这两个节点遍历完之后最终还是返回节点1，在回到节点1的时候就应该把节点2的值给移除掉，让list变为[1]，然后再沿着1→4这个分支走下去，结果就是[1，4]。


总结一下回溯算法的代码模板

private void backtrack("原始参数") {
    //终止条件(递归必须要有终止条件)
    if ("终止条件") {
        //一些逻辑操作（可有可无，视情况而定）
        return;
    }

    for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
        //一些逻辑操作（可有可无，视情况而定）

        //做出选择

        //递归
        backtrack("新的参数");
        //一些逻辑操作（可有可无，视情况而定）

        //撤销选择
    }
}
————————————————
版权声明：本文为CSDN博主「一个写湿的程序猿」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_32727095/article/details/115672861
  */