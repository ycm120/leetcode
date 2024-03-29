package com.ycm.test.hw;

/**
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:03
 */
public class Test07 {
    /**
     *小明在学习二进制时，发现了一类不含101的数，也就是：
     * 将数字用二进制表示，不能出现101。
     * 现在给定一个整数区间【L，r】，请问这个区间包含了多少个不含101的数？
     * 输入描述
     * 输入的唯一行包含两个正整数l，r（1≤1≤r≤10^9）。
     * 输出描述
     * 输出的唯一一行包含一个整数，表示在【L.r】区间内一共有几个不含101的数。
     * 样例
     * 样例一：
     * 输入1 10
     * 输出8
     * 样例解释
     * 区间【1，10】内，5的二进制表示为101，10的二进制表示为1010，因此区间【1，1】内有10-2=8个不含101的数。
     * 样例二：
     * 输入10 20
     * 输出7
     * 样例解释
     * 区间【10，20】内，满足条件的数字有【12，14，1516，17，18，19】因此答案为7。
     */
    public static void main(String[] args) {
        Integer number = test(1, 10);
        System.out.println(number);
        Integer number2 = test(10, 20);
        System.out.println(number2);




    }








    public static Integer test(Integer start, Integer end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            if (!Integer.toBinaryString(i).contains("101")) {
                sum++;
            }
        }
        return sum;
    }


}
