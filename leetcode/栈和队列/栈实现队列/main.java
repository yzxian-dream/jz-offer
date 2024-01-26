import java.util.Stack;

// class CQueue {
//     Stack<Integer> stack1;
//     Stack<Integer> stack2;
//     构造函数
//      public CQueue() {
//         stack1 = new Stack<Integer>();
//         stack2 = new Stack<Integer>();
//      }
//      public void appendTail(int value) {
//         stack1.push(value);
//      }
//      public int deleteHead() {
       //这段逻辑放在取节点就是为了避免一直取，Stack2取完了，stack1的取不到了（送不进Stack），一直为空
//          if(stack2.isEmpty()){
//              while(!stack1.isEmpty()){
//                  stack2.push(stack1.pop());
//              }
//          }
//          if (stack2.isEmpty()){
//              return -1;
//          }
//          return stack2.pop();
//      }
//  }

class main{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int v){
        stack1.push(v);
    }
    public int pop(){
        if (stack2.empty()){
            //todo
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


}

