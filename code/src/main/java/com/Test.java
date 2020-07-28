package main.java.com;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.Title27.findContinuousSequence;

/**
 * 注解javadoc演示
 *
 * @author yzx
 * @since 1.5
 */

public class Test {
    /**
     * 计算两数的和
     *
     * @param a 整数
     * @param b 整数
     * @return 两数的和
  */
    public static void main(String[] args) {
        List<List<Integer>> continuousSequence = findContinuousSequence(15);
        for (int i = 0; i < continuousSequence.size(); i++) {
            List<Integer> integers = continuousSequence.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j));

            }
            System.out.println();

        }
    }
}




