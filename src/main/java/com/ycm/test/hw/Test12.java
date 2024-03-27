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
        int ghostNumber = Integer.parseInt(input.split(" ")[0]);
        int wolfNumber = Integer.parseInt(input.split(" ")[1]);
        int shipCapacity = Integer.parseInt(input.split(" ")[2]);
        List<String> shifLog = new ArrayList<>();// 转移记录 每次转移一个
        while (ghostNumber + wolfNumber > 0) {
            // 羊或者狼还没运输完 运输时优先确保对岸的羊不比狼少 而本岸的则确保羊比狼多一个即可 由于是单次运输 所以对岸的羊可能会和狼一样多
            if (ghostNumber - wolfNumber > 1) {
                // 运输一个羊
                ghostNumber--;
                shifLog.add("g");
                continue;
            }
            if (wolfNumber > 0) {
                // 否则运输狼
                wolfNumber--;
                shifLog.add("w");
            } else {
                // 只剩一个羊
                ghostNumber--;
                shifLog.add("g");
            }
        }
        System.out.println(shifLog);
        // 来检测单个运输过程 是否可以合并为一次的 求出最小运输次数
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("g", 0);
        map.put("w", 0);
        int count = 0; // 运输了几次
        int left = 0;
        int right = shipCapacity;// 第一次运算
        wolfNumber = Integer.parseInt(input.split(" ")[1]);
        shipCapacity = Integer.parseInt(input.split(" ")[2]);
        if (left == right - 1 && ghostNumber - wolfNumber < wolfNumber) {
            // 船容量是1 且羊的数量不是狼的2倍 那么这样是不可能移动成功的
            System.out.println(0);
            System.exit(0);
        }
        while (left < shifLog.size()) {
            int wN = 0;
            int gN = 0;
            int onceCount = 0;
            for (int i = 0; i < right - left; i++) {
                if (left + i >= shifLog.size()) {
                    break;
                }
                onceCount++;
                if (shifLog.get(left + i).equals("w")) {
                    wN++;
                } else {
                    gN++;
                }
            }
            if (map.get("g") + gN > map.get("w") + wN) {
                count++;
                map.put("g", map.get("g") + gN);
                map.put("w", map.get("w") + wN);
                left += onceCount;
                right += shipCapacity;
                // 这是一次有效的运输 指针右移到下一次
                System.out.println("第" + count + "次有效运输，运输的羊和狼为：" + gN + ":"
                        + wN);
            } else {
                right--;
                if (right == left) {
                    System.out.println(0);
                    break;
                }
            }
        }
        System.out.println(count);















    }
}
