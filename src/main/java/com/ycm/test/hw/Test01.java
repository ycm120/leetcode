package com.ycm.test.hw;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: rik.yang
 * @date: 2024/3/21 16:45
 */
public class Test01 {

    /**
     * 题目
     * 一、题目
     * 输入一个长度为4的倍数的字符串，字符串中仅包含WASD四个字母。
     * 将这个字符串中的连续子串用同等长度的仅包含WASD的字符串替换Q，如果替换后整个字符串中WASD四个字母出现的频数相同，那么我们称替换后的字符串是“完美走位”。求子串的最小长度。
     * 如果输入字符串已经平衡则输出0。
     * 二、输入
     * 一行字符表示给定的字符串s 数据范围： 1<=n<=10^5且n是4的倍数，字符串中仅包含WASD四个字母。
     * 三、输出一个整数表示答案
     * 四、样例输入输出示例
     * 1：输入：WASDAASD 输出：1 说明： 将第二个A替换为W，即可得到完美走位。
     * 示例2：输入：AAAA 输出：3 说明：将其中三个连续的A替换为WSD，即可得到完美走位
     */

    public static void main(String[] args) {
        Integer result = test("WASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASDAASDWASD");
        System.out.println(result);
    }

    /**
     * 1：先用一个map统计出字符串所有的字符个数，然后先看是否"完美"。
     * 2. 根据滑动窗口找出可以满足改变窗口里数据能达到完美的窗口，找出最小距离，窗口不满足右移，满足则左滑动
     *
     * @param input
     * @return
     */
    private static Integer test(String input) {
        char[] arrays = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = new char[] {'W', 'A', 'S', 'D'};
        for (char c : charArray) {
            map.put(c, 0);
        }
        for(char c : arrays) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int target = arrays.length / 4;
        if(map.get('W') == target && map.get('A') == target && map.get('S') == target && map.get('D') == target) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int minLength = arrays.length;
        map.put(arrays[0], map.getOrDefault(arrays[0], 0) - 1);
        while (right < arrays.length && left <= right) {
            char c = arrays[right];
            int needLength = needLength(map);
            int nowLength = right - left + 1;
            int length = nowLength - needLength;
            if (length >= 0 && length % 4 == 0) {
                if (nowLength == 1) {
                    return 1;
                }
                minLength = Math.min(minLength, nowLength);
                // left++
                map.put(arrays[left], map.getOrDefault(arrays[left], 0) + 1);
                left++;
            } else {
                right++;
                if (right < arrays.length) {
                    map.put(arrays[right], map.getOrDefault(arrays[right], 0) - 1);
                }
            }
        }
        return minLength;
    }

    private static int needLength(Map<Character, Integer> map) {
        int maxNum = 0;
        for(Integer value : map.values()) {
            maxNum = Math.max(maxNum, value);
        }
        return maxNum * 4 - map.getOrDefault('W', 0) - map.getOrDefault('A', 0) - map.getOrDefault('S', 0) - map.getOrDefault('D', 0);
    }


}
