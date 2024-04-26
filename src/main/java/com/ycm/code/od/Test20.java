package com.ycm.code.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * 最大平分数组
 * @author: rik.yang
 * @date: 2024/3/22 16:14
 */
public class Test20 {
    /**
     * 题目描述
     * 给定一个数组nums，可以将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，最大的平分组个数。
     *
     * 输入
     * 第一行输入 m
     *
     * 接着输入m个数，表示此数组
     *
     * 数据范围:1<=M<=50, 1<=nums[i]<=50
     *
     * 输出
     * 最大的平分组数个数。
     *
     * 样例输入 复制
     * 7
     * 4 3 2 3 5 2 1
     * 样例输出 复制
     * 4
     */
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{4, 3, 2, 3, 5, 2, 1};
        int length = arrays.length;
        int sum = 0;
        int maxNum = 0;
        int maxGroup = 1;
        for(int num : arrays) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        List<Integer> groupList = new ArrayList<>();
        for(int i = length; i >= 2; i--) {
            if (sum % i == 0 && maxNum <= sum / i) {
                groupList.add(i);
            }
        }
        Arrays.sort(arrays, (num1, num2) -> num2 - num1);
        for(int groupNum : groupList) {
            if (canGroup(groupNum, arrays, sum)) {
                maxGroup = groupNum;
                break;
            }
        }
        System.out.println(maxGroup);

    }







    public static boolean canGroup(int groupNum, Integer[] arrays, int sum) {
        int[] groupArrays = new int[groupNum];
        int target = sum / groupNum;
        for(int num : arrays) {
            for(int i = 0; i < groupNum; i++) {
                if (groupArrays[i] + num <= target) {
                    groupArrays[i] += num;
                    break;
                }
            }
        }
        for(int num : groupArrays) {
            if(num != target) {
                return false;
            }
        }
        return true;
    }






















}
