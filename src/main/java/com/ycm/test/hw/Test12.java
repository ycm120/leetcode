package com.ycm.test.hw;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
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



        String input = "5 3 5";
        String[] arrays = input.split(" ");
        int count = test(arrays);
        System.out.println(count);
    }

    private static int test(String[] arrays) {
        return 0;
    }
}
