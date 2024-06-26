package com.ycm.code.od;

import java.util.Scanner;

/**
 *
 *
 * 模拟商场优惠打折
 * @author: rik.yang
 * @date: 2024/3/22 16:12
 */
public class Test22 {

    /**
     * 模拟商场优惠打折，有三种优惠券可以用，满减券、打折券和无门槛券。
     *   满减券：满 100 减 10，满 200减 20，满300减30，满 400减40，以此类推不限制使用；
     *   打折券：固定折扣 92 折，且打折之后向下取整，每次购物只能用 1 次；
     *   无门槛券：一张券减 5 元，没有使用限制；
     * 每个人结账使用优惠券时有以下限制：
     *   每人每次只能用两种优惠券，并且同一种优惠券必须一次用完，不能跟别的穿插使用（比如用一张满减，再用一张打折，再用一张满减，这种顺序不行）。
     * 求不同使用顺序下每个人用完券之后得到的最低价格和对应使用优惠券的总数；
     * 如果两种顺序得到的价格一样低，就取使用优惠券数量较少的那个。
     *
     * 输入输出描述：
     * 输入描述：
     *   第一行三个数字 m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量
     *   第二行一个数字 x, 表示有几个人购物
     *   后面 x 行数字，依次表示是这几个人打折之前的商品总价
     *
     * 输出描述：
     *   输出每个人使用券之后的最低价格和对应使用优惠券的数量
     *
     * 示例1：
     * 输入：
     * 	3 2 5
     * 	3
     * 	100
     * 	200
     * 	400
     * 输出：
     * 	65 6
     * 	135 8
     * 	275 8
     * 说明:
     * 	第一个人使用 1 张满减券和 5 张无门槛券价格最低。
     * 	第二个人使用 3 张满减券和 5 张无门槛券价格最低。
     * 	第三个人使用 3 张满减券和 5 张无门槛券价格最低。
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     * 10
     * 11
     * 12
     * 13
     * 14
     * 解题思路：
     * 根据题目规则，优惠有四种方案，计算出每种方案的花费和用券情况，针对花费和用券进行排序即可。
     * 无门槛最后用或者不用
     * 四种方案分别是：
     * ① 先打折 - 后满减
     * ② 先打折 - 后用无门槛券
     * ③ 先满减 - 后打折
     * ④ 先满减 - 后用无门槛券
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] arrays = line1.split(" ");
        int m = Integer.parseInt(arrays[0]);
        int n = Integer.parseInt(arrays[1]);
        int k = Integer.parseInt(arrays[2]);
        int x = scanner.nextInt();
        for(int i = 0; i < x; i++) {
            int money = scanner.nextInt();
            int minMoney = money;
            int minCount = m + n + k;
            int moneym = money;
            int countm = 0;
            while(countm < m && moneym >= 100) {
                countm++;
                moneym = moneym - moneym / 100 * 10;
            }
            int money1 = moneym;
            int count1 = countm;
            if(n > 0) {
                count1++;
                money1 = money1 * 92 / 100;
            }
            if (money1 == minMoney) {
                minCount = Math.min(minCount, count1);
            } else if(money1 < minMoney) {
                minMoney = money1;
                minCount = count1;
            }
            int money2 = moneym;
            int count2 = countm;
            if (k > 0) {
                count2 += k;
                money2 = money2 - 5 * k;
            }
            if (money2 == minMoney) {
                minCount = Math.min(minCount, count2);
            } else if(money2 < minMoney) {
                minMoney = money2;
                minCount = count2;
            }
            int moneyn = money;
            int countn = 0;
            if (n > 0) {
                countn = 1;
                moneyn = moneyn * 92 / 100;
            }
            int money3 = moneyn;
            int count3 = countn;
            int countm2 = 0;
            while(countm2 < m && money3 >= 100) {
                countm2++;
                money3 = money3 - money3 / 100 * 10;
            }
            count3 += countm2;
            if (money3 == minMoney) {
                minCount = Math.min(minCount, count3);
            } else if(money3 < minMoney) {
                minMoney = money3;
                minCount = count3;
            }

            int money4 = moneyn;
            int count4 = countn;
            if (k > 0) {
                count4 += k;
                money4 = money4 - 5 * k;
            }






            if (money4 == minMoney) {
                minCount = Math.min(minCount, count4);
            } else if(money4 < minMoney) {
                minMoney = money4;
                minCount = count4;
            }
            System.out.println(minMoney + " " + minCount);

        }
    }

}
