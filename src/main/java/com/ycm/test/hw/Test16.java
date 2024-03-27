package com.ycm.test.hw;

import java.util.Arrays;

/**
 *
 * 二元组个数
 * @author: rik.yang
 * @date: 2024/3/22 16:13
 */
public class Test16 {
    /**
     * 题目描述：
     * 给定两个数组a，b，若a[i] == b[j] 则称 [i, j] 为一个二元组，求在给定的两个数组中，二元组的个数。
     *
     * 输入输出描述：
     * 输入描述：
     *   第一行输入 m
     *   第二行输入 m 个数，表示第一个数组
     *   第三行输入 n
     *   第四行输入n个数，表示第二个数组
     *
     * 输出描述：二元组个数。
     *
     * 示例1：
     * 输入：
     * 	4
     * 	1 2 3 4
     * 	1
     * 	1
     * 输出：
     * 	1
     * 说明：二元组个数为 1个
     * 示例2：
     * 输入：
     * 	4
     * 	1 1 2 2
     * 	3
     * 	2 2 4
     * 输出：
     * 	4
     * 说明：二元组个数为 4 个
     *
     * 解题思路：
     *
     *
     *
     *
     *
     * 两个数组排序后 循环找，技巧1：数组1先找出一样下次循环跳过这个，从数组2找出一样数据相乘，记录数组2循环位置，下次可以跳过循环过
     * 时间复杂度
     * 近似于O[m+n]
     *
     */
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 1, 2};
        int[] array2 = new int[]{2, 4, 2};
        Arrays.sort(array1);
        Arrays.sort(array2);
        int number = 0;
        int lastindex = 0;
        for(int i = 0; i < array1.length; i++) {
            int number1 = array1[i];
            System.out.println("number:" + number1);
            int sames = 1;
            while(i < array1.length - 1 && number1 == array1[i + 1]) {
                i++;
                sames++;
            }
            int sames2 = 0;
            for(int j = lastindex; j < array2.length; j++) {
                int number2 = array2[j];
                System.out.println(number2);
                lastindex = j;
                if(number2 == number1) {
                    sames2++;
                } else if (number2 > number1) {
                    break;
                }
            }
            number += sames * sames2;
        }
        System.out.println(number);
    }






}
