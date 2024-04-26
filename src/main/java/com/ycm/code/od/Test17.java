package com.ycm.code.od;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 *
 * 打印机队列
 * @author: rik.yang
 * @date: 2024/3/22 16:13
 */
public class Test17 {
    /**
     * 题目描述
     *
     * 有5台打印机打印文件，每台打印机有自己的待打印队列。
     * 因为打印的文件内容有轻重缓急之分，所以队列中的文件有1~10不同的代先级，其中
     * 数字越大优先级越高
     * 打印机会从自己的待打印队列中选择优先级最高的文件来打印。
     * 如果存在两个优先级一样的文件，则选择最早进入队列的那个文件。
     * 现在请你来模拟这5台打印机的打印过程。
     *
     * 输入描述
     *
     * 每个输入包含1个测试用例，
     *
     * 每个测试用例第一行给出发生事件的数量N（0 < N < 1000）。
     *
     * 接下来有 N 行，分别表示发生的事件。共有如下两种事件：
     *
     * “IN P NUM”，表示有一个拥有优先级 NUM 的文件放到了打印机 P 的待打印队列中。（0< P <= 5, 0 < NUM <= 10)；
     * “OUT P”，表示打印机 P 进行了一次文件打印，同时该文件从待打印队列中取出。（0 < P <= 5）。
     * 输出描述
     *
     * 对于每个测试用例，每次”OUT P”事件，请在一行中输出文件的编号。
     * 如果此时没有文件可以打印，请输出”NULL“。
     * 文件的编号定义为”IN P NUM”事件发生第 x 次，此处待打印文件的编号为x。编号从1开始。
     * 用例
     * 输入
     * 7
     * IN 1 1
     * IN 1 2
     * IN 1 3
     * IN 2 1
     * OUT 1
     * OUT 2
     * OUT 2
     * 输出
     * 3
     * 4
     * NULL
     *
     * 输入
     * 5
     * IN 1 1
     * IN 1 3
     * IN 1 1
     * IN 1 3
     * OUT 1
     * 输出
     * 2
     * 说明	无
     *
     * 原文链接：https://blog.csdn.net/qq_33183456/article/details/130931191
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int count = Integer.parseInt(line1);
        Map<String, List<PrintTask>> map = new HashMap<>();
        Map<String, Boolean> map2 = new HashMap<>();
        int index = 1;
        for(int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            String[] arrays = line.split(" ");
            if ("IN".equals(arrays[0])) {
                List<PrintTask> list = map.getOrDefault(arrays[1], new ArrayList<>());
                list.add(new PrintTask(Integer.parseInt(arrays[2]), index));
                index++;
                map.put(arrays[1], list);
                map2.put(arrays[1], false);
            } else if("OUT".equals(arrays[0])) {
                List<PrintTask> list = map.get(arrays[1]);
                if (null == list || list.isEmpty()) {
                    System.out.println("NULL");
                } else {
                    boolean ordered = map2.getOrDefault(arrays[1], false);
                    if (!ordered) {
                        list.sort((task1, task2) -> {
                           if (task1.value != task2.value) {
                               return task2.value - task1.value;
                           } else {
                               return task1.index - task2.index;
                           }
                        });
                        map2.put(arrays[1], true);
                    }
                    System.out.println(list.get(0).index);
                    list.remove(0);
                    map.put(arrays[1], list);
                }
            }
        }
    }

    public static class PrintTask {
        public int value;

        public int index;

        public PrintTask(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }



}
