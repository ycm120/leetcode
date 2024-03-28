package com.ycm.test.hw;

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
        String input="1 2 3 4 5 6 7";
        String[] arrays = input.split(" ");
        int length = arrays.length;
        int sum = 0;
        Integer[] arrayNum = new Integer[length];
        int maxNum = 0;
        for(int i = 0; i < length; i++) {
            arrayNum[i] = Integer.parseInt(arrays[i]);
            sum += arrayNum[i];
            maxNum = Math.max(maxNum, arrayNum[i]);
        }
        System.out.println(maxNum);
        List<Integer> groupList = new ArrayList<>();
        for (int i = length; i > 1; i--) {
            if (sum % i == 0 && maxNum <= sum / i) {
                groupList.add(i);
            }
        }
        if(0 == groupList.size()) {
            System.out.println(sum);
            return;
        }
        Arrays.sort(arrayNum, (num1, num2) -> num2 - num1);
        for (Integer group : groupList) {
            if (canGroup(group, arrayNum, sum)) {
                System.out.println(sum/ group);
                return;
            }
        }
    }
    public static boolean canGroup(int groupNum, Integer[] arrayNum, int sum){
        int target = sum / groupNum;
        int[] sumArray = new int[groupNum];
        for(Integer num : arrayNum) {
            for (int i = 0; i < groupNum; i++) {
                if (sumArray[i] + num <= target) {
                    sumArray[i] = sumArray[i] + num;
                    break;
                }
            }
            System.out.println(Arrays.toString(sumArray));
        }
        for (int oneSum : sumArray) {
            if (oneSum != target) {
                return false;
            }
        }

        return true;
    }

}
