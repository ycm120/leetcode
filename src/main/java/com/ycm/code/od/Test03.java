package com.ycm.code.od;

import java.util.Arrays;

/**
 * @author: rik.yang
 * @date: 2024/3/22 14:50
 */
public class Test03 {
    /**
     * 【租车骑绿岛】100分
     * 部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，做最大载重M。给出部门每个人的体重，请问最多需要租用多少双人自行车。
     * 输入描述：
     * 第一行两个数字m、n，分别代表自行车限重，部门总人数。
     * 第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。
     * 0<m<=200
     * 0<n<=1000000
     * 输出描述：
     * 最小需要的双人自行车数量。
     *
     * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例输入
     * 3 4
     * 3 2 2 1
     * 输出
     * 3
     */
    public static void main(String[] args) {
        Integer test = test(3, 4, new Integer[]{3, 2, 2, 1});
        System.out.println(test);
    }









    public static Integer test(Integer m, Integer n, Integer[] array) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        int partyNum = 0;
        while (left < right) {
            if (array[left] + array[right] <= m) {
                partyNum++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        return n - partyNum;
    }



}
