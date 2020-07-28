package main.java.com;
/*输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
        例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。*/
import java.util.ArrayList;
import java.util.Comparator;

public class Title32 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int x : numbers){
            list.add(x+"");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a1 = o1+o2;
                String a2 = o2+o1;
                return a1.compareTo(a2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String x : list){
            sb.append(x);
        }
        return sb.toString();
    }
}
