package com.ycm.code.od;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: rik.yang
 * @date: 2024/3/22 16:15
 */
public class Test21 {
    // 连接器问题
    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        int[] nums2 = new int[length];
        dfs(0, new ArrayList<>(), res, nums, length, nums2);
        return res;
    }

    public static void dfs(int index, List<Integer> list, List<List<Integer>> res, int[] nums, int length, int[] nums2) {
        System.out.println("dfs: index: " + index + ", list: " + JSON.toJSONString(list) + ", nums2: " + Arrays.toString(nums2));
        if(index == length) {
            System.out.println("一次选择完成");
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < length; i++) {
            System.out.println("循环 i " + i);
            if(nums2[i] == 0) {
                list.add(nums[i]);
                nums2[i] = 1;

                dfs(index + 1, list, res, nums, length, nums2);
                // 回溯


                System.out.println("一次回溯开始 list: " + JSON.toJSONString(list));
                nums2[i] = 0;
                list.remove(list.size() - 1);
                System.out.println("一次回溯完成");
            }
        }

    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
    }
}
