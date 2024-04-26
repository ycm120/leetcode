package com.ycm.code.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 *
 * 本题是一道经典的「拓扑排序」问题
 * https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 * https://leetcode.cn/problems/course-schedule-ii/ 记录么次选修课程就行
 * @author: rik.yang
 * @date: 2024/4/26 10:26
 */
public class Test1 {



    public static void main(String[] args) {
        // 使用bfs, 用一个队列保存入度为0的节点（入度表示这个课程前提课程），学习入度为0的课程后，以他为入度的课程减1，循环可得到总共学习课程
        boolean canFinish1 = canFinish1(2, new int[][]{{1, 0}});
        System.out.println(canFinish1);
    }


    private static boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 创建一个列表来存储所有可能的路径
        List<List<Integer>> list = new ArrayList<>();
        // 初始化每个元素 in each element in the list to be an empty list
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        // 初始化一个数组来存储每个节点的入度
        int[] inDegree = new int[numCourses];
        // 构建图，增加每个前置课程的入度，并添加边到列表
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            list.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 创建一个队列来存储没有任何入度的节点
        Deque<Integer> queue = new ArrayDeque<>();

        // 将没有任何入度的节点添加到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.push(i);
            }
        }
        int count = 0;
        // 处理队列中的节点
        while (queue.size() > 0) {
            count++;
            int course = queue.pop();

            // 处理与当前节点相连的边
            for (int nextCourse : list.get(course)) {
                inDegree[nextCourse]--;

                // 如果相邻节点没有任何入度，将其添加到队列中
                if (inDegree[nextCourse] == 0) {
                    queue.push(nextCourse);
                }
            }
        }

        // 返回 true 如果所有节点都已经处理，否则返回 false
        return count == numCourses;
    }


}
