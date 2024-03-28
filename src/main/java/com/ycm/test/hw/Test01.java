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
        return 0;
    }



}
