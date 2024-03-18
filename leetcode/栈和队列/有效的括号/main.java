package 栈和队列.有效的括号;
/*
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
import java.util.Stack;
/*
 * 题目简单，不过题解的细节还是值得学习。一是s长度为奇数时可以直接排除，二是可以用哈希表实现快速配对(而不是写一堆switch和if else)
 */
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return  false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            // 将 })] 作为key
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        // 新建一个栈
        // LinkedList<Character> stack = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果c是 })], 则判断， 否则说明是({[ , 直接入栈
            if(map.containsKey(c)){
                // stack.peek() 获取栈顶元素
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                // 将栈顶移除(先进后出，栈顶是最接近 c 的左括号)
                stack.pop();
            }else{
                // 说明c是({[ , 直接入栈
            stack.push(c);
        }
        }
        return stack.isEmpty();
    }
}
