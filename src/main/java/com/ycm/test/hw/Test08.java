package com.ycm.test.hw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 过滤组合字符串
 * @author: rik.yang
 * @date: 2024/3/22 16:04
 */
public class Test08 {
    /**
     * 数字0、1、2、3、4、5、6、7、8、9分别关联 a~z 26个英文字母。
     * 0关联"a"，"b"，"c"
     * 1关联"d"，"e"，"f"
     * 2关联"g"，"h"，"i"
     * 3关联”J“，”k”，“T”
     * 4关联"m"，"n"，"o"
     * 5关联"p"，"q"，"r"
     * 6关联"s"，"t"
     * 7关联"u"，"V"
     * 8关联"w"，"x"
     * 9关联"y"，"z"
     * 例如7关联"u"，"V"，8关联"×"，"w"，输入一个字符串例如"78"，
     * 和一个屏蔽字符串“Ux'，那么'78'可以组成多个字符串例如：“ux'，“uw'，“ww\”，过滤这些完全包含屏蔽字符串的每一个字符的字符串，然后输出剩下的字符串。
     * 示例：输入：78 UX 输出：UW VX VW
     * 说明：ux完全包含屏蔽字符串ux，因此剔除
     */
    public static void main(String[] args) {
        char[][] arrays = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 't'}, {'m', 'n', 'o'}, {'p', 'q', 'r'}, {'s', 't'}, {'u', 'v'}, {'w', 'x'}, {'z', 'y'}};
        String number = "78";
        String str = "ux";
        char[] chars = str.toCharArray();
        char[] array1 = number.toCharArray();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            char[] chars1 = arrays[array1[i] - '0'];
            if (i == 0) {
                for(char c : chars1) {
                    list.add(new StringBuilder(c + ""));
                }
            } else {
                List<StringBuilder> sbList = new ArrayList<>();
                for(char c : chars1) {
                    for(StringBuilder sb : list) {
                        sbList.add(new StringBuilder(sb).append(c));
                    }
                }
                list = sbList;
            }
        }
        for(StringBuilder sb : list) {
            if(!check(sb.toString(), chars)) {
                System.out.println(sb.toString() + " ");
            }
        }
    }

    public static boolean check(String str, char[] arrays) {
        char[] charArray = str.toCharArray();
        for(char c : arrays) {
            if(!str.contains(c + "")) {
                return false;
            }
        }
        return true;
    }

}
