package com.ycm.code.od;

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







    public static int solution = 0;


    public static int[] colors = null;

    public static List<Line> lineList = new ArrayList<>();

    public static Integer test() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] arrays1 = line1.split(" ");
        int num1 = Integer.parseInt(arrays1[0]);
        int num2 = Integer.parseInt(arrays1[1]);
        for (int i = 0; i < num2; i++) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            lineList.add(new Line(Integer.parseInt(array[0]) - 1, Integer.parseInt(array[1]) - 1));
        }
        colors = new int[num1];
        colored(0, num1);
        return solution;
    }

    private static void colored(int index, int number) {
        if (index < number) {
            if (colors[index] == 0) {
                colors[index] = 1;
                colored(index + 1, number);
                colors[index] = 2;
                for (Line line : lineList) {
                    if (line.from == index) {
                        colors[line.to] = 1;
                    }
                    if (line.to == index) {
                        colors[line.from] = 1;
                    }
                }
                colored(index + 1, number);
            } else {
                colored(index + 1, number);
            }
            // 回溯
            colors[index] = 0;
        } else {
            solution++;
        }
    }


    static class Line {
        public int from;

        public int to;

        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }


    }







}
