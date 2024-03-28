package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: rik.yang
 * @date: 2024/3/22 15:19
 */
public class Test04 {
    /**
     * 给一个无向图Q染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方蜜？
     * 输入描述： 第一行输入M（图中节点数）N（边数） 后续N行格式为：V1V2表示一个V1到V2的边。
     * 数据范围：1<=M<=15，0<=N<=M*3，不能保证所有节点都是连通的。
     * 输出描述：
     * 输出一个数字表示染色方案的个数。
     * 示例1：
     * 输入：
     * 4 4
     * 1 2
     * 2 4
     * 3 4
     * 1 3
     * 输出：
     * 7
     * 说明：4个节点，4条边，1号节点和2号节点相连，2号节点和4号节点相连，3号节点相4号节点相连，1号节点和3号节点相连，若想必须保证相邻两个节点不能同时为红色，总共7种方案。
     */
    public static void main(String[] args) {
        Integer test = test();
        System.out.println(test);
    }




    private static List<LineNode> nodeList = new ArrayList<>();

    private static int[] colors = null;

    private static Integer sum = 0;

    public static Integer test() {
        return 0;
    }

    public static void color(Integer index) {

    }





    public static class LineNode {
        public Integer fromIndex;

        public Integer toIndex;

        public LineNode (Integer fromIndex, Integer toIndex) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

    }







}
