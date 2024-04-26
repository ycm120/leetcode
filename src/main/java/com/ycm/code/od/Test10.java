package com.ycm.code.od;

import java.util.Scanner;

/**
 *
 *
 * 最小调整顺序次数
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:04
 */
public class Test10 {
    /**
     *给定一个队列，但是这个队列比较特殊，可以从头部添加数据，也可以从尾部添加数据，但是只能从头部删除数据，输入一个数字n，会依次添加数字1~n（也就是添加n次）。
     * 但是在添加数据的过程中，也会删除数据，要求删除必须按照1～n按照顺序进行删除，所以在删除时，可以根据需要调整队列中数字的顺序以满足删除条件。输入描述：
     * 第一行一个数据N，表示数据的范围。
     * 接下来的2N行是添加和删除语句Q。其中；head add x表示从头部添加元素X，tail add表示从属部添加元素，remove表示删除元素。输出描述：
     * 输出一个数字，表示最小的调整顺序次数。
     * 示例：
     * 5
     *  head add 1
     * tail add 2
     * remove
     * head add 3
     *  tail add 4
     * head add 5
     *  remove
     *  remove
     *  remove
     *  remove
     * 输出：1
     * 说明：
     * 第1步：【1】
     * 第2步：【1，2】
     * 第3步：头部删除1，无需调整，还剩【2】
     * 第4步：【3，2】
     * 第5步：【3，2，4】
     * 第6步：【5，3，2，4】
     * 第7步：头部删除2，调整顺序再删除，还剩3，4，5】
     * 第8步：头部删除3，无需调整，还剩【4，5】第9步：头部删除4，无需调整，还剩【5】
     * 第10步：头部删除5，无需调整只需要调整1次
     */
    public static void main(String[] args) {
        Integer count = test();
        System.out.println(count);
    }








    public static Integer test() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int count = Integer.parseInt(line1);
        boolean ordered = true;
        int size = 0;
        int sortNum = 0;
        for (int i = 0; i < count * 2; i++) {
            String line = scanner.nextLine();
            if(line.startsWith("head")) {
                if (size > 0) {
                    ordered = false;
                }
                size++;
            } else if(line.startsWith("tail")) {
                size++;
            } else {
                if (!ordered && size > 0) {
                    sortNum++;
                    size--;
                    ordered = true;
                }
            }
        }
        return sortNum;
    }

}
