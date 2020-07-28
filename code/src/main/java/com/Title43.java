package main.java.com;
/*汇编语言中有一种移位指令叫做循环左移（ROL），
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！*/
//方法一
/*public class Title43 {
    public String LeftRotateString(String str,int k){
        int len = str.length();
        if (len <= 1){
            return str;
        }
        k = k % len;
        str += str.substring(0,k);//abcXYZdefadc
        return str.substring(k);//从第n位开始返回即XYZdefabc
    }
}*/
//方法二：时间复杂度O(n),空间复杂度o（1）
public class Title43 {
    public String LeftRotateString(String str,int n) {

        char[] strArr=str.toCharArray();//把字符串转化为字符数组，相当于数组反转
        int len=strArr.length;
        if(len==0)
            return str;
        n=n%len;
        reverseStr(strArr,0,n-1);//左旋abcdefg---->cdefgab(设n=2)
        reverseStr(strArr,n,len-1);
        reverseStr(strArr,0,len-1);
        //底下的反转是右旋，abcdefg---->fgabcde
        /*reverseStr(strArr,0,len-1-n);
        reverseStr(strArr,len-n,len-1);
        reverseStr(strArr,0,len-1);*/

        return new String(strArr);
    }
    public void reverseStr(char[] array,int begin,int end){  //反转字符串，前后指针
        while(begin<end){
            char temp =array[begin];
            array[begin]=array[end];
            array[end]=temp;
            begin++;
            end--;
        }
    }
}