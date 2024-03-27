package com.ycm.test.hw;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 处理器问题
 * @author: rik.yang
 * @date: 2024/3/22 16:14
 */
public class Test18 {
    /**
     * 某公司研发了一款高性能AI处理器。每台物理设备具备8颗AI处理器，编号分别为0、1、2、3、4、5、6、7。
     * 编号0-3的处理器处于同一个链路中，编号4-7的处理器处于另外一个链路中，不通链路中的处理器不能通信。
     * 如下图所示。现给定服务器可用的处理器编号数组array，以及任务申请的处理器数量num，找出符合下列亲和性调度原则的芯片组合。
     * 如果不存在符合要求的组合，则返回空列表。
     * 亲和性调度原则：
     * -如果申请处理器个数为1，则选择同一链路，剩余可用的处理器数量为1个的最佳，其次是剩余3个的为次佳，然后是剩余2个，最后是剩余4个。
     * -如果申请处理器个数为2，则选择同一链路剩余可用的处理器数量2个的为最佳，其次是剩余4个，最后是剩余3个。
     * -如果申请处理器个数为4，则必须选择同一链路剩余可用的处理器数量为4个。
     * -如果申请处理器个数为8，则申请节点所有8个处理器。
     * 提示：
     * 任务申请的处理器数量只能是1、2、4、8。\n编号0-3的处理器处于一个链路，编号4-7的处理器处于另外一个链路。
     * 处理器编号唯一，且不存在相同编号处理器。
     *
     *
     * 输入描述
     *
     * 输入包含可用的处理器编号数组array，以及任务申请的处理器数量num两个部分。
     * 第一行为array，第二行为num。例如：
     * [0, 1, 4, 5, 6, 7] 1
     * 表示当前编号为0、1、4、5、6、7的处理器可用。任务申请1个处理器。
     * 0 <= array.length <= 8
     * 0 <= array[i] <= 7
     * num in [1, 2, 4, 8]
     *
     * 输出描述
     *
     * 输出为组合列表，当array=[0，1，4，5，6，7]，num=1 时，输出为[[0], [1]]
     *
     * 输入
     * [0, 1, 4, 5, 6, 7]
     * 1
     * 输出
     * [[0], [1]]
     * 说明
     * 根据第一条亲和性调度原则，在剩余两个处理器的链路（0, 1, 2, 3）中选择处理器。
     *
     * 由于只有0和1可用，则返回任意一颗处理器即可。
     *
     * 输入
     * [0, 1, 4, 5, 6, 7]
     * 4
     * 输出
     * [[4, 5, 6, 7]]
     * 说明	根据第三条亲和性调度原则，必须选择同一链路剩余可用的处理器数量为4个的环
     *
     *
     *
     */
    public static void main(String[] args) {
        int[] arrays1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        List<Integer> cpu1List = new ArrayList<>();
        List<Integer> cpu2List = new ArrayList<>();
        for (int cpuNo : arrays1) {
            if (cpuNo <= 3) {
                cpu1List.add(cpuNo);
            } else {
                cpu2List.add(cpuNo);
            }
        }

        int cpu1Size = cpu1List.size();
        int cpu2Size = cpu2List.size();
        int number = 2;
        List<Integer[]> list = new ArrayList<>();
        if (number == 8) {
            if (arrays1.length == 8) {
                int[][] arrays2 = new int[1][8];
                arrays2[0] = arrays1;
                System.out.println(JSON.toJSONString(arrays2));
            } else {
                System.out.println("[]");
            }
        } else if(number == 1) {
            if (cpu1Size == 1 || cpu2Size == 1) {
                if (cpu1Size == 1) {
                    addList1(cpu1List, list);
                }
                if (cpu2Size == 1) {
                    addList1(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else if (cpu1Size == 3 || cpu2Size == 3) {
                if (cpu1Size == 3) {
                    addList1(cpu1List, list);
                }
                if (cpu2Size == 3) {
                    addList1(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else if (cpu1Size == 2 || cpu2Size == 2) {
                if (cpu1Size == 2) {
                    addList1(cpu1List, list);
                }
                if (cpu2Size == 2) {
                    addList1(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else if (cpu1Size == 4 || cpu2Size == 4) {
                if (cpu1Size == 4) {
                    addList1(cpu1List, list);
                }
                if (cpu2Size == 4) {
                    addList1(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else {
                System.out.println("[]");
            }
        }  else if(number == 2) {
            if (cpu1Size == 2 || cpu2Size == 2) {
                if (cpu1Size == 2) {
                    addList2(cpu1List, list);
                }
                if (cpu2Size == 2) {
                    addList2(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else if (cpu1Size == 4 || cpu2Size == 4) {
                if (cpu1Size == 4) {
                    addList2(cpu1List, list);
                }
                if (cpu2Size == 4) {
                    addList2(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else if (cpu1Size == 3 || cpu2Size == 3) {
                if (cpu1Size == 3) {
                    addList2(cpu1List, list);
                }
                if (cpu2Size == 3) {
                    addList2(cpu2List, list);
                }
                System.out.println(JSON.toJSONString(list));
            } else {
                System.out.println("[]");
            }
        } else if (number == 4) {
            if (cpu1Size == 4 || cpu2Size == 4) {
                if (cpu1Size == 4) {
                    list.add(cpu1List.toArray(new Integer[0]));
                }
                if (cpu2Size == 4) {
                    list.add(cpu2List.toArray(new Integer[0]));
                }
                System.out.println(JSON.toJSONString(list));
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void addList2(List<Integer> cpuList, List<Integer[]> list) {
        for(int i = 0; i < cpuList.size(); i++) {
            for (int j = i + 1; j < cpuList.size(); j++) {
                Integer[] arrays = new Integer[2];
                arrays[0] = cpuList.get(i);
                arrays[1] = cpuList.get(j);
                list.add(arrays);
            }
        }
    }

    private static void addList1(List<Integer> cpuList, List<Integer[]> list) {
        for(Integer cpuNo : cpuList) {
            Integer[] arrays = new Integer[1];
            arrays[0] = cpuNo;
            list.add(arrays);
        }
    }


}
