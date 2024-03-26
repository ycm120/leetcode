package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 区间交叠问题
 * @author: rik.yang
 * @date: 2024/3/22 16:12
 */
public class Test15 {

    /**
     * 问题描述
     * 给定坐标轴上的一组线段，线段的起点和终点均为整数并且长度不小于1，请你从中找到最少数量的线段，这些线段可以覆盖住所有线段。
     *
     * 输入描述
     * 第一行输入为所有线段的数量，不超过10000，后面每行表示一条线段，格式为”x,y”，
     *
     * x和y 分别表示起点和终点，取值范围是[-105，105]。
     *
     * 输出描述
     * 最少线段数量，为正整数。
     *
     * 示例1
     * 输入输出示例仅供调试，后台判题数据一般不包含示例
     *
     * 输入
     * 3
     * 1 4
     * 2 5
     * 3 6
     * 输出
     * 2
     *
     * 输入
     * 4
     * 1 3
     * 2 4
     * 4 8
     * 5 9
     * 输出
     * 2
     *
     * 输入
     * 3
     * 1 6
     * 2 5
     * 5 7
     * 输出
     * 2
     *
     * 把所有线段按左端升序， 右端降序
     * 先选择两端线段，如果有多个选择最大，出现两端一样加1，不一样加2继续选择，重叠加2
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int lineSize = Integer.parseInt(line1);
        List<Line> lineList = new ArrayList<>();
        for(int i = 0; i < lineSize; i++) {
            String line = scanner.nextLine();
            String[] arrays = line.split(" ");
            lineList.add(new Line(Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1])));
        }
        List<Line> leftList = lineList.stream().sorted((lineOne, lineTwo) -> lineOne.left - lineTwo.left).toList();
        System.out.println(leftList);
        List<Line> rightList = lineList.stream().sorted((lineOne, lineTwo) -> lineTwo.right - lineOne.right).toList();
        System.out.println(rightList);
        int lineNum = 0;
        int left = leftList.get(0).left;
        int right = rightList.get(0).right;
        int leftIndex = 0;
        int rightIndex = 0;
        while(true) {
            int maxLeftRight = left;
            Line leftLine = null;
            for(int i = leftIndex; i < lineSize; i++) {
                Line line = leftList.get(i);
                if(left >= line.left) {
                    if (maxLeftRight < line.right) {
                        maxLeftRight = line.right;
                        leftLine = line;
                    }
                } else {
                    leftIndex = i;
                    break;
                }
            }
            int minleft = right;
            Line rightLine = null;
            for(int i = rightIndex; i < lineSize; i++) {
                Line line = rightList.get(i);
                if(right <= line.right) {
                    if (minleft > line.left) {
                        minleft = line.left;
                        rightLine = line;
                    }
                } else {
                    rightIndex = i;
                    break;
                }
            }
            if (leftLine.right >= rightLine.left) {
                if (leftLine.left >= rightLine.left) {
                    lineNum++;
                    System.out.println("加1");
                    break;
                } else {
                    lineNum += 2;
                    System.out.println("加2");
                    break;
                }
            } else {
                lineNum += 2;
                left = leftLine.right;
                right = rightLine.left;
                System.out.println("加2");
            }
        }
    }


    public static class Line {
        public int left;

        public int right;
        public Line (int left, int right) {
            this.left = left;
            this.right = right;

        }

        @Override
        public String toString() {
            return "Line{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }




}
