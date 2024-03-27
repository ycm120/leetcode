package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 羊、狼、农夫过河
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:07
 */
public class Test12 {
    /**
     * 羊、狼、农夫过河】
     *    羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
     *    要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。只计算农夫去对岸的次数，回程时农夫不会运送羊和狼备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。农夫自身不占用船的容量。
     * 输入描述
     * 第一行输入为M，N，×，分别代表羊的数量，狼的数量，小船的容量。
     * 输出描述
     * 输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。（若无法满足条件则输出0）
     * 示例一
     * 输入
     * 5 3 3
     * 输出
     * 3
     * 说明
     * 第一次运2只狼
     * 第二次运3只羊
     * 第三次运2只羊和1只狼
     *
     * 示例一
     * 输入
     * 5 4 1
     * 输出
     * 0
     * 说明
     * 如果找不到不损失羊的运送方案，输出0
     */
    public static void main(String[] args) {



        String input = "5 4 3";
        String[] arrays = input.split(" ");
        int count = test(arrays);
        System.out.println(count);
    }

    private static int test(String[] arrays) {
        int animal1 = Integer.parseInt(arrays[0]);
        int animal2 = Integer.parseInt(arrays[1]);
        int capacity = Integer.parseInt(arrays[2]);
        if (animal1 <= animal2) {
            return 0;
        }
        // 多一个情况下，只能一次性把相同都带过去。
        if (animal1 - animal2 == 1) {
            if (capacity < animal1) {
                return 0;
            } else if (capacity >= animal1 + animal2) {
                return 1;
            } else {
                return 2;
            }
        }
        int count = 0;
        int[] arrays2 = new int[animal1 + animal2];
        int index = 0;
        // 先按一次1个容量来
        while(animal1 > 0 || animal2 > 0) {
            // 多了2个优先去对岸
            if (animal1 - animal2 > 1) {
                arrays2[index] = 1;
                index++;
                animal1--;
                continue;
            }
            if (animal2 > 0) {
                arrays2[index] = 2;
                index++;
                animal2--;
            } else {
                arrays2[index] = 1;
                index++;
                animal1--;
            }
        }
        System.out.println(arrays2);
        int left = 0;
        int right = capacity;
        int number1 = 0;
        int number2 = 0;
        while (left < arrays2.length) {
            int num1 = 0;
            int num2 = 0;
            for(int i = left; i < right; i++) {
                if (i >= arrays2.length) {
                    break;
                }
                if (arrays2[i] == 1) {
                    num1++;
                } else if(arrays2[i] == 2) {
                    num2++;
                } else {
                    return 0;
                }
            }
            if (number1 + num1 > number2 + num2) {
                number1 += num1;
                number2 += num2;
                count++;
                System.out.println("第" + count + "次运送，num1: " + num1 + ", number1: " + number1 + ", num2: " + num2 + ", number2: " + number2);
                left += num1;
                left += num2;
                right = left + capacity;
            } else {
                right--;
                if (right - left <= 0) {
                    return 0;
                }
            }

        }

        return count;
    }
}
