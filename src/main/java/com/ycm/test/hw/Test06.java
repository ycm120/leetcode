package com.ycm.test.hw;

import java.util.Scanner;

/**
 *
 *
 * 最多颜色的车辆
 * @author: rik.yang
 * @date: 2024/3/22 16:03
 */
public class Test06 {
    /**
     * 题目内容
     * 在一个狭小的路口，每秒只能通过一辆车，假好车辆的颜色只有3种，找出N秒内经过的最多颜色的车辆数量。三种颜色编号为0，1，2
     * 输入描述
     * 第一行输入的是通过的车辆颜色信息
     * 【0，1，1，2】代表4秒钟通过的车辆颜色分别是0，1，1，2
     * 第二行输入的是统计时间窗，整型，单位为秒
     * 输出描述
     * 输出指定时间窗内经过的最多颜色的车辆数量。
     * 样例
     *
     * 样例一：
     * 输入
     * 0 1 2 1
     * 3
     * 输出
     * 2
     * 样例解释
     * 在3秒时间窗内，每个颜色最多出现2次。例为：【1，2，1】
     * 样例二：
     * 输入
     * 0 1 2 1
     * 2
     * 输出
     * 1
     * 样例解释
     * 在2秒时间窗内，每个颜色最多出现1次
     */
    public static void main(String[] args) {
        Integer answer = test();
        System.out.println(answer);
    }









    public static Integer test() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrays = line.split(" ");
        int second = scanner.nextInt();
        int left = 0;
        int right = second - 1;
        int[] array = new int[3];
        for(int i = 0; i < right; i++) {
            array[Integer.parseInt(arrays[i])]++;
        }
        int max = getMax(array);
        right++;
        while(right < arrays.length) {
            int temp = Integer.parseInt(arrays[right]);
            int temp2 = Integer.parseInt(arrays[left]);
            array[temp]++;
            array[temp2]--;
            max = Math.max(max, getMax(array));
            left++;
            right++;
        }
        return max;
    }
    public static Integer getMax(int[] array) {
        return Math.max(array[0], Math.max(array[1], array[2]));
    }

}
