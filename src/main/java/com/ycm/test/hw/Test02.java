package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 【字符串重新排列】
 *
 * @author: rik.yang
 * @date: 2024/3/22 11:48
 */
public class Test02 {
    /**
     * 给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出：
     * 1、单词内部调整：对每个单词字母重新按字典序排序
     * 2、单词间顺序调整：
     * 1）统计每个单词出现的次数，并按次数降序排列2）次数相同，按单词长度升序排列
     * 3）次数和单词长度均相同，按字典升序排列请输出处理后的字符串，每个单词以一个空格分隔。
     * 输入描述：
     * 一行字符串，每个字符取值范围：【a-ZA-Z0-9】以及空格，字符串长度范围：【1，1，1000】
     * 例1：
     * 输入
     * This is an apple
     * 输出
     * an is This aelpp
     * 例2：
     * 输入：
     * My sister is in the house not in the yard
     * 输出：
     * in in eht eht My is not adry ehosu eirsst
     */

    public static void main(String[] args) {
        String test = test("This is an apple");
        System.out.println(test);

        String test2 = test("is sister My in the house not in the yard");
        System.out.println(test2);
    }


    /**
     * 1：题目还是比较简单的，直接两步排序即可，需要细心的地方有两个
     * A：就是排序是降序还是升序。
     * B：输出的时候要输出单词原有的个数。
     * 字符按照字典表排序 Arrays.sort();
     * 字符串按照字典白哦排序，利用自定义排序 compareTo
     *
     * @param input
     * @return
     */
    public static String test(String input) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] arrays1 = input.split(" ");
        for(String str : arrays1) {
            char[] chars1 = str.toCharArray();
            Arrays.sort(chars1);
            str = new String(chars1);
            list.add(str);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        list.sort((str1, str2) -> {
            if (!map.get(str1).equals(map.get(str2))) {
                return map.get(str2) - map.get(str1);
            } else if (str1.length() != str2.length()) {
                return str1.length() - str2.length();
            } else {
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }


}
