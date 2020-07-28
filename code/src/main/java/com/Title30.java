package main.java.com;
//连续子数组的最大和
//例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
public class Title30 {
    /*  public int FindGreatestSumOfSubArray(int[] array) {
          int max = array[0];
          for (int i = 0; i < array.length; i++) {
              array[i] += array[i + 1] < 0 ? 0 : array[i + 1];
              max = Math.max(max, array[i]);
          }
          return max;
      }
  }*/
    public int FindGreatestSumOfSubArray(int[] array) {
        int Max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            Max = Math.max(sum, Max);
            if (sum < 0) {//sum小于0再往后加会对后面的数有削弱作用，所以让sum=0重新在取子序列的和与max比较
                sum = 0;
            }
        }
        return Max;
    }
}
