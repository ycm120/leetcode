package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 单向链表中间节点
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:02
 */
public class Test05 {
    /**
     * 题目描述
     * 求单向链表Q中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值。
     * 输入描述：
     * 第一行链表头节点地址path后续输入的节点数n
     * 后续输入每行表示一个节点，格式："节点地址 节点值 下一个节点地址（-1表示空指针）"输入保证链表不会出现环，并且可能存在一些节点不属于链表。
     * 输出描述：
     * 链表中间节点值。
     * 测试用例：
     * 输入：
     * 00010 4
     * 00000 3 -1
     * 00010 5 12309
     * 11451 6 00000
     * 12309 7 11451
     * 输出：
     * 6
     *
     */
    public static void main(String[] args) {
        String answer = test();
        System.out.println(answer);
    }




    public static String test() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] arrays1 = line1.split(" ");
        String head = arrays1[0];
        Integer nodeNumber = Integer.parseInt(arrays1[1]);
        List<Node> nodeList = new ArrayList<>();
        Map<String, Node> map = new HashMap<>();
        for(int i = 0; i < nodeNumber; i++) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            map.put(array[0], new Node(array[0], array[1], array[2]));
        }
        Node firstNode = map.get(head);
        Node tempNode = firstNode;
        while (tempNode != null) {
            nodeList.add(tempNode);
            String next = tempNode.next;
            if("-1".equals(next)) {
                break;
            }
            tempNode = map.get(next);
        }
        Integer nodeSize = nodeList.size();
        if (nodeSize == 1) {
            return nodeList.get(0).value;
        } else if (nodeSize % 2 == 0) {
            return nodeList.get(nodeSize / 2).value;
        } else {
            return nodeList.get(nodeSize / 2).value;
        }
    }




    public static class Node {
        public String now;

        public String value;

        public String next;


        public Node(String now, String value, String next) {
            this.now = now;
            this.value = value;
            this.next = next;
        }


    }

}
