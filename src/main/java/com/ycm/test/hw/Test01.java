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
        char[] chars1 = input.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : chars1) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int neddOne = chars1.length / 4;
        if (neddOne == countMap.get('A') && countMap.get('W') == neddOne && countMap.get('S') == neddOne && countMap.get('D') == neddOne) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int minLength = chars1.length;
        countMap.put(chars1[0], countMap.getOrDefault(chars1[0], 0) - 1);
        while(right < chars1.length && left < chars1.length) {
            int maxCharCount = getMaxCharCount(countMap);
            int size = right -left + 1;
            int now = size - maxCharCount;
            if (now >= 0 && now % 4 == 0) {
                if (size == 1) {
                    return 1;
                }
                minLength = Math.min(minLength, size);
                countMap.put(chars1[left], countMap.getOrDefault(chars1[left], 0) + 1);
                left++;
            } else {
                right++;
                if (right < chars1.length) {
                    countMap.put(chars1[right], countMap.getOrDefault(chars1[right], 0) - 1);
                }
            }
        }
        return minLength;
    }

    /**
     * 获取 到达完全走位至少需要的字母数量， 窗口里满足窗口外
     * 具体步骤如下：
     * 1： 先获取map里最大的一个字符数量
     * 2： 用最大的字符数量 * 4 再减去map里各个里字符的数量， 比如  A AAA, 窗口长度是是1,只有一个A， 剩下3个A
     * 最大字符数是3 那么起码需要 3*4-3-0-0=9个数的窗口长度来填，才能保证完全走位
     * 如果是AA AA ，左边的窗口是2， 右边最大char num是2， 对应: 2*4-2-0-0 = 6，6个数的窗口
     * 如果是AAA A， 左边的窗口是3， 右边最大char num是1， 对应： 1*4- 1-0-0-0， 正好3个数的窗口
     *
     * @param charCountMap
     * @return 返回到达完全走位至少需要的字母数量
     */
    public static int getMaxCharCount(Map<Character, Integer> charCountMap) {
        int maxCount = 0;
        for(Integer value : charCountMap.values()) {
            maxCount = Math.max(maxCount, value);
        }
        return maxCount * 4 - charCountMap.getOrDefault('W', 0) - charCountMap.getOrDefault('A', 0)
                - charCountMap.getOrDefault('S', 0) - charCountMap.getOrDefault('D', 0);
    }

}
