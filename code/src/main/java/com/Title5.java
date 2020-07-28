package main.java.com;
/*题目描述
        用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/
import java.util.Stack;
//思路：通过两个栈中元素之间的复制交换实现了队列，栈一负责接收节点数据
//栈二负责弹出数据，由栈的特性可知栈弹出的数据即为栈一中顺序输入的顺序
public class Title5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push (int node){
        stack1.push(node);//栈一负责接收节点数据
    }
    public int pop(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());//栈二负责弹出数据，由栈的特性可知栈弹出的数据即为栈一中顺序输入的顺序
            }
        }
        return stack2.pop();
    }
}
