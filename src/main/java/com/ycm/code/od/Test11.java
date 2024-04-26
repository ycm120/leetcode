package com.ycm.code.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *
 * 最大化控制资源成本
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:05
 */
public class Test11 {
    /**
     * 最大化控制资源成本】
     *
     * 题目描述
     *
     * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，请你设计算法帮他们解决一个任务混部问题：
     *
     * 有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime），并行度（parallelism）三个属性，
     *
     * 并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完成立即释放（结束时刻不占用）。
     *
     * 任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，
     *
     * 请你计算完成这批任务混部最少需要多少服务器，从而最大化控制资源成本。
     *
     * 输入描述：
     *
     * 第一行输入为taskNum，表示有taskNum项任务
     * 接下来taskNum行，每行三个整数，表示每个任务的
     *
     * 开始时间（startTime ），结束时间（endTime ），并行度（parallelism）
     *
     * 输出描述：
     *
     * 一个整数，表示最少需要的服务器数量
     *
     * 示例1   输入输出示例仅供调试，后台判断数据一般不包含示例
     *
     * 输入
     *
     * 3
     * 2 3 1
     * 6 9 2
     * 0 5 1
     *
     * 输出
     *
     * 2
     *
     * 说明
     *
     * 一共有三个任务，第一个任务在时间区间[2, 3]运行，占用1个服务器，
     * 第二个任务在时间区间[6, 9]运行，占用2个服务器，
     * 第三个任务在时间区间[0, 5]运行，占用1个服务器，
     * 需要最多服务器的时间区间为[2, 3]和[6, 9]，需要2个服务器。
     *
     * 示例2   输入输出示例仅供调试，后台判断数据一般不包含示例
     *
     * 输入
     *
     * 2
     * 3 9 2
     * 4 7 3
     *
     * 输出
     *
     * 5
     *
     * 说明
     * 一共两个任务，第一个任务在时间区间[3, 9]运行，占用2个服务器，
     * 第二个任务在时间区间[4, 7]运行，占用3个服务器，
     * 需要最多服务器的时间区间为[4, 7]，需要5个服务器。
     *
     * 备注：
     *
     * 1 <= taskNum <= 100000
     * 0 <= startTime < endTime <= 50000
     * 1 <= parallelism <= 100
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int taskNum = Integer.parseInt(line1);
        int[] arrays = new int[50001];

        for(int i = 0; i < taskNum; i++) {
            String line = scanner.nextLine();
            String[] taskArray = line.split(" ");
            int startTime = Integer.parseInt(taskArray[0]);
            int endTime = Integer.parseInt(taskArray[1]);
            int count = Integer.parseInt(taskArray[2]);
            for(int j = startTime; j <= endTime; j++) {
                arrays[j] += count;
            }
        }
        Arrays.sort(arrays);
        int maxCount = arrays[50000];
        System.out.println(maxCount);
    }


}
