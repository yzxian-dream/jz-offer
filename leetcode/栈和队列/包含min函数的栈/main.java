import java.util.Stack;

//辅助栈
public class main {
    /** initialize your data structure here. */
       Stack<Integer> normal = new Stack<>();//数据栈
       Stack<Integer> minstack = new Stack<>();//存放此刻最小值的栈
   
       public void MinStack() {
           normal = new Stack<>();
           minstack = new Stack<>();
       }
   
       public void push(int x) {
           normal.push(x);
           minstack.push(minstack.isEmpty() ? x : Math.min(minstack.peek(), x));
       }
   
       public void pop() {
           normal.pop();
           minstack.pop();
       }
   
       public int top() {
           return normal.peek();
       }
   
       public int min() {
           return minstack.peek();
       }
   }
   
   /**
    * Your MinStack object will be instantiated and called as such:
    * MinStack obj = new MinStack();
    * obj.push(x);
    * obj.pop();
    * int param_3 = obj.top();
    * int param_4 = obj.min();
    */

    // class MinStack {
    //     Stack<Integer> stack1;
    //     Stack<Integer> stack2;
    //     /** initialize your data structure here. */
    //     public MinStack() {
    //         stack1 = new Stack<Integer>();
    //         stack2 = new Stack<Integer>();
    //     }
        
    //     public void push(int x) {
    //         stack1.push(x);
    //         if(stack2.isEmpty() || x <= stack2.peek()){
    //             stack2.push(x);
    //         }
    //     }
        
    //     public void pop() {
    //         if(!stack1.isEmpty()){
    //             if(stack1.peek().intValue() == stack2.peek().intValue()){
    //                  stack2.pop();
    //             }
    //             stack1.pop();
    //         }
           
    //     }
        
    //     public int top() {
    //         return stack1.peek();
    //     }
        
    //     public int min() {
    //         return stack2.pop();
    //     }
    // }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

     class MinStack {
        /** initialize your data structure here. */
           Stack<Integer> normal; //数据栈
           Stack<Integer> minstack; //存放此刻最小值的栈
       
           public MinStack() {
               normal = new Stack<>();
               minstack = new Stack<>();
           }
       
           public void push(int x) {
               normal.push(x);
               minstack.push(minstack.isEmpty() ? x : Math.min(minstack.peek(), x));
           }
       
           public void pop() {
               normal.pop();
               minstack.pop();
           }
       
           public int top() {
               return normal.peek();
           }
       
           public int min() {
               return minstack.peek();
           }
       }