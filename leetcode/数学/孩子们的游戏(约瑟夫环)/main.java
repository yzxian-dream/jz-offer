package 数学.孩子们的游戏

import java.util.ArrayList;

(约瑟夫环);
/* 
 * 社团共有 num 为成员参与破冰游戏，编号为 0 ~ num-1。成员们按照编号顺序围绕圆桌而坐。
 * 社长抽取一个数字 target，从 0 号成员起开始计数，排在第 target 位的成员离开圆桌，且成员离开后从下一个成员开始计数。请返回游戏结束时最后一位成员的编号。

 

示例 1：

输入：num = 7, target = 4
输出：1
示例 2：

输入：num = 12, target = 5
输出：0
 */

 //这种方法会溢出
// public class main {
//     public int iceBreakingGame(int num, int target) {
//         //定义一个arrayList来存储kids成员
//         ArrayList<Integer> arr = new ArrayList<>();
//         for (int i = 0; i < num; i++) {
//             arr.add(i);
//         }

//         int index = -1; //定义每次要删除的下标,进循环要加一，会到0，这里不能是0
        
//         while (arr.size()>1) {
//             //代表没删到还剩唯一一个
//             int count = 0;
//             while (count < target) {
//                 count++;
//                 index++;
//                 if (index == num-1) {
//                     index = 0;
//                 }
//             }
//             arr.remove(index);
//             index--;  //删掉后已经是新的值了，先退一位，进循环在走。
            
//         }
//         return arr.get(0);
//     }

// }
/* 
 * 我们将上述问题建模为函数 f(num, target)，该函数的返回值为最终留下的元素的序号。

首先，长度为 num 的序列会先删除第 target % num 个元素，然后剩下一个长度为 num - 1 的序列。那么，我们可以递归地求解 f(num - 1, target)，就可以知道对于剩下的 num - 1 个元素，
最终会留下第几个元素，我们设答案为 x = f(num - 1, target)。

由于我们删除了第 target % num 个元素，将序列的长度变为 num - 1。当我们知道了 f(num - 1, target) 对应的答案 x 之后，我们也就可以知道，
长度为 num 的序列最后一个删除的元素，应当是从 target % num 开始数的第 x 个元素。因此有 f(num, target) = (target % num + x) % num = (target + x) % num。


 */
class Solution {
    public int iceBreakingGame(int num, int target) {
        return f(num, target);
    }

    public int f(int num, int target) {
        if (num == 1) { //任何数对1取余都是0
            return 0;
        }
        int x = f(num - 1, target);
        return (target % num + x) % num;
    }
}


//找出每次出环的数
class Solution {
    public int ysf(int num, int target,int i) {
        //i表示第i个人出环的编号，
        if(i==1){
            return (target-1)%num;
        }else{
            return (ysf(n-1,k,i-1)+target)%n;
        }
    }
}


