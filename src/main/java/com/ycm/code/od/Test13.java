package com.ycm.code.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * 等和子数组最小和
 * @author: rik.yang
 * @date: 2024/3/22 16:08
 */
public class Test13 {
    /**
     * 给定一个数组nums，将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，组内元素和的最小值
     * 输入描述：
     * 第一行输入m
     * 接着输入m个数，表示此数组
     * 数据范围：1<=M<=50，1<=nums【i】<=50 输出描述：
     * 最小拆分数组和。
     * 示例：
     * 输入：
     * 7
     * 4 3 2 3 5 2 1
     * 输出： 5
     * 说明：可以等分的情况有： 4个子集（5），（1，4），（2，3），（2，3）2个子集（5，1，4），（2，3，2，3）但最小的为5。
     */
    public static void main(String[] args) {
        String input="4 3 2 3 5 2 1";
        String[] arrays = input.split(" ");
        int length = arrays.length;
        Integer[] numbers = new Integer[length];
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(arrays[i]);
            sum += numbers[i];
            maxNum = Math.max(numbers[i], maxNum);
        }
        List<Integer> groupList = new ArrayList<>();
        for (int i = length; i >= 2; i--) {
            if (sum % i == 0 && sum / i >= maxNum) {
                groupList.add(i);
            }
        }
        Arrays.sort(numbers, (num1, num2) -> num2 - num1);
        for (int i = 0; i < groupList.size(); i++) {
            int groupNum = groupList.get(i);
            if (canGroup(groupNum, numbers, sum)) {
                System.out.println(sum / groupNum);
                return;
            }
        }
        System.out.println(" " + sum);
    }
    public static boolean canGroup(int groupNum, Integer[] arrayNum, int sum){
        int target = sum / groupNum;
        int[] groupCount = new int[groupNum];
        for(int number : arrayNum) {
            for (int i = 0; i < groupNum; i++) {
                if(groupCount[i] + number <= target) {
                    groupCount[i] += number;
                    break;
                }
            }
        }
        for(int count : groupCount) {
            if(target != count) {
                return false;
            }
        }
        return true;
    }

}
