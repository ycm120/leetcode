package com.ycm.test.hw;

import java.util.ArrayList;
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
        List<String> list = new ArrayList<>();
        for(String str : array) {
            if (str.length() == 1) {
                list.add(str);
            } else {
                if (list.contains(str.substring(0, str.length() - 1))) {
                    list.add(str);
                }
            }
        }
        list.sort((str1, str2) -> {
           if (str1.length() != str2.length()) {
               return str2.length() - str1.length();
           } else {
               return str2.compareTo(str1);
           }
        });
        return list.get(0);
    }


}
