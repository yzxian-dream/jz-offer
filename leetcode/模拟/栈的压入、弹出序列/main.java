package 模拟.栈的压入

import java.util.Stack;

、弹出序列;
/* 
 * 描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
1. 0<=pushV.length == popV.length <=1000
2. -1000<=pushV[i]<=1000
3. pushV 的所有数字均不相同

[1,2,3,4,5],[4,5,3,2,1]
输入：
[1,2,3,4,5],[4,5,3,2,1]
复制
返回值：
true
复制
说明：
可以通过push(1)=>push(2)=>push(3)=>push(4)=>pop()=>push(5)=>pop()=>pop()=>pop()=>pop()
这样的顺序得到[4,5,3,2,1]这个序列，返回true   


输入：
[1,2,3,4,5],[4,3,5,1,2]
复制
返回值：
false
复制
说明：
由于是[1,2,3,4,5]的压入顺序，[4,3,5,1,2]的弹出顺序，要求4，3，5必须在1，2前压入，且1，2不能弹出，但是这样压入的顺序，1又不能在2之前弹出，所以无法形成的，返回false      
 */
public class main {
    //这道题的关键在于你要建一个辅助栈模拟就好理解，
    //对于给定的input和output的，则他的push和pop的执行顺序就是唯一的
    //找到一点，把input依次入辅助栈，用辅助栈的栈顶元素和output的第一个元素开始比较，如果相等，辅助站出站，output index++；
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stackhelp = new Stack<>();
        int index = 0;
        for (int num : putIn) {
            stackhelp.push(num);
            while (!stackhelp.isEmpty() && stackhelp.peek() == takeOut[index]) {
                stackhelp.pop();
                index++;
            }
        }
        return stackhelp.isEmpty();

    }

}
