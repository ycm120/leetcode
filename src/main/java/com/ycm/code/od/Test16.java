package com.ycm.code.od;

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
        int[] arrays1 = new int[]{1, 2, 3, 4};
        int[] arrays2 = new int[]{1};
        Arrays.sort(arrays1);
        Arrays.sort(arrays2);
        int count = 0;
        int index = 0;
        for (int i = 0; i < arrays1.length; i++) {
            int num = arrays1[i];
            int count1 = 1;
            while(i + 1 < arrays1.length && arrays1[i + 1] == num) {
                i++;
                count1++;
            }
            int count2 = 0;
            for(int j = index; j < arrays2.length; j++) {
                int num2 = arrays2[j];
                if (num2 > num) {
                    index = j;
                    break;
                }
                if (num2 == num) {
                    count2++;
                }
            }
            count += count1 * count2;
        }
        System.out.println(count);
    }






}
