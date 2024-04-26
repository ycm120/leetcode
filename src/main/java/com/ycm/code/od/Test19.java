package com.ycm.code.od;

/**
 *
 *
 * 探索地块建立
 * @author: rik.yang
 * @date: 2024/3/22 16:14
 */
public class Test19 {
    /**
     * 输入一个二维数组m*n, c为正方形，满足的电力为k
     * 2 5 2 6
     * 1 3 4 5 1
     * 2 5 6 7 1
     * 2 5 6 7 1
     * 2 5 6 7 1
     *
     * https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
     */
    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 3, 4, 5, 1}, {2, 5, 6, 7, 1}, {2, 5, 6, 7, 1}, {2, 5, 6, 7, 1}};
        int m = arrays.length;
        int n = arrays[0].length;
        int[][] sums = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + arrays[i][j];
            }
        }
        int count = 0;
        int c = 2;
        int k = 15;
        for(int i = 0; i < m; i++) {
            int r1 = i;
            int r2 = i + c - 1;
            if(r2 >= m) {
                break;
            }
            for(int j = 0; j < n; j++) {
                int c1 = j;
                int c2 = j + c - 1;
                if(c2 >= n) {
                    break;
                }
                int sum = getSum(r1, c1, r2, c2, sums);
                if (sum >= k) {
                    System.out.println(sum);
                    count++;
                }
            }
        }
        System.out.println(count);
    }





    public static int getSum(int r1, int c1, int r2, int c2, int[][] sums) {
        System.out.println(r1 + " " + c1 + " " + r2 + " " + c2);
        return sums[r2 + 1][c2 + 1] - sums[r2 + 1][c1] - sums[r1][c2 + 1] + sums[r1][c1];
    }



}
