package 位运算.数组中数字出现的次数II;
//在一个数组nums中除一个数出现过一次之外，其他数字都出现了三次，请找出那个只出现一次的数字
/* 
 * 1 <= actions.length <= 10000
   1 <= actions[i] < 2^31
 */
//先找出求解该题的一个特征，就是出现过三次的数在每个位上0或1都出现了三次，将它相加它一定是3的倍数，
//对3取余一定是0，，将所有数位数相加，对%3，如果为1，则单独那个数该位上为1，否则为0.
public class main {
    public int trainingPlan(int[] actions) {
        int bitMask = 1<<31;  //由于数组里的最大数的位数可能到31位，所以定义到31位为1
        int res = 0;
        //循环从高位往低位移动1，100000--->010000---->001000
        for (int i = 0; i < 32; i++) {
            int bitSum = 0; //用来存储该位数之和
            for (int n : actions) {
                if((bitMask & n) != 0){
                    bitSum++;
                }
            }
            res = (res << 1) + bitSum%3;
            bitMask>>=1;
        }
        return res;
    }
}

/* 
 * 
 * class Solution {
    public int trainingPlan(int[] actions) {
        int[] counts = new int[32];
        for(int action : actions) {
            for(int i = 0; i < 32; i++) {
                counts[i] += action & 1; // 更新第 i 位 1 的个数之和
                action >>= 1;            // 第 i 位 --> 第 i 位
            }
        }
        int res = 0, m = 3;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % m;        // 恢复第 i 位
        }
        return res;
    }
}
 */

// 使用hashmap来做
/* 
 * // 使用 HashMap 记录各个数字出现的次数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = nums.length - 1; i >= 0; --i){
            int key = nums[i];
            if(!map.containsKey(key)){
                // 如果之前没有遇到这一数字，则放入 map 中
                map.put(key, 1);
            }else{
                // 如果之前遇到过这一数字，则出现次数加 1
                map.put(key, map.get(key) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }
 */
// [5,2,2,2,5,5,4]