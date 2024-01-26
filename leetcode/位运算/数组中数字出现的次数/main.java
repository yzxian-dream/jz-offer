package 位运算.数组中数字出现的次数;


//一般这种第一时间想到用哈希表做，但这里要求是空间复杂度O(1)，所以不能建hash，可以采用位运算

//第一种情况：一个数字出现一次，其他都出现两次，只需要进行一次全员异或就可以找出出现一次的值
// public class main {
//     public int getNum(int[] nums){
//         int singeNum = 0;
//         for (int i : nums) {
//             singeNum^=i;//相同的值异或会被抵消掉为0
//         }
//         return singeNum;
//     }
// }


//第二种情况，两个数子出现一次，这样就要满足两个条件
//1. 两个出现一次的数字放在不同的组
//2. 相同的数字分成相同的组
//这里有几个位于算公式
// x^y =1
//a^b^c = a(b^c)
//z=x^y
//通过z&1找出第几个二进制位不同
//先全员异或得到的就是那两个只出现一次不同数字的异或的结果
//找到第一位不是0的位，说明那两个不同的值在该位上是不同的，
// 然后使用这个值h和数组里的所有值相与，根据该位是否为0将其分为两个不同的组（一位那两个值在这一位上与h相与必然是不同的），
//最后这样就可以回归到第一种情况在把各组进行一次全员异或就可以找出那个不同的值了。
public class main {
    public int[] sockCollocation(int[] sockets) {
        int ret = 0; //保存全员异或结果
        int a = 0;
        int b = 0;
        for (int n : sockets) {
            ret ^= n;
        }
        int h = 1;
        while ((ret & h) == 0 ) {
            h <<= 1;
        }
        for (int n : sockets) {
            if ((h & n) == 0) {
                a ^= n;
            }else{
                b ^= n;
            }
        }
        return new int[]{a,b};
    }
}
