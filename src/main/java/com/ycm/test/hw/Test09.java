package com.ycm.test.hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * 真正的密码
 *
 * @author: rik.yang
 * @date: 2024/3/22 16:04
 */
public class Test09 {
    /**
     * 在一行中输入一个字符串数组Q，如果其中一个字符串的所有以索引O开头的子串在数组中都有，那么这个字符串就是潜在密码，在所有潜在密码中最长的是真正的密码，如果有多个长度相同的真正的密码，那么取字典序最大的为唯一的真正的密码，求唯一的真正的密码。
     * 示例1：
     * 输入：  h ha hal halc hao he hel hell hello o ok n ni nin ninj ninja
     * 输出： ninja
     * 说明：按要求，hello、ok、ninja都是潜在密码。检查长度，hello、ninja是真正的密码。检查字典序，ninja是唯一真正密码。
     * 示例2：
     * 输入：a b c d f
     * 输出：f
     * 说明：按要求，a b c d f都是潜在密码。检查长度，a b c d f是真正的密码。检查字典序，f是唯一真正密码。
     */
    public static void main(String[] args) {
        String password = test(new String[]{"h", "he", "ha", "hal", "hallo", "hall", "o", "ok", "okk", "okkkk", "okkk"});
        System.out.println(password);
    }

    public static String test(String[] array) {
        Arrays.sort(array);
        Set<String> password = new TreeSet<>();
        for (String wordStr : array) {
            if (wordStr.length() == 1) {
                password.add(wordStr);
            } else {
                if(password.contains(wordStr.substring(0, wordStr.length() - 1))) {
                    password.add(wordStr);
                }
            }
        }
        List<String> passwordList = password.stream().sorted((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word2.length() - word1.length();
            } else {
                return word2.compareTo(word1);
            }
        }).toList();
        return passwordList.get(0);
    }


}
