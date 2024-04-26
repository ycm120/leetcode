package com.ycm.code.od;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
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
        Integer[] arrays = new Integer[]{0, 2, 1, 4, 5, 6, 7};
        int needNum = 2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int no : arrays) {
            if(no <= 3) {
                list1.add(no);
            } else {
                list2.add(no);
            }
        }

        int size1 = list1.size();
        int size2 = list2.size();

        List<Integer[]> list = new ArrayList<>();
        if(needNum == 8) {
            if(arrays.length == 8) {
                list.add(arrays);
            }
        } else if(needNum == 1) {
            if (size1 == 1 || size2 == 1) {
                if (size1 == 1) {
                    list.add(list1.toArray(new Integer[0]));
                }
                if (size2 == 1) {
                    list.add(list2.toArray(new Integer[0]));
                }
            } else if(size1 == 3 || size2 == 3) {
                if (size1 == 3) {
                    addToList1(list1, list);
                }
                if (size2 == 3) {
                    addToList1(list2, list);
                }
            } else if(size1 == 2 || size2 == 2) {
                if (size1 == 2) {
                    addToList1(list1, list);
                }
                if (size2 == 2) {
                    addToList1(list2, list);
                }
            } else if(size1 == 4 || size2 == 4) {
                if (size1 == 4) {
                    addToList1(list1, list);
                }
                if (size2 == 4) {
                    addToList1(list2, list);
                }
            }
        } else if(needNum == 2) {
            if (size1 == 2 || size2 == 2) {
                if (size1 == 2) {
                    list.add(list1.toArray(new Integer[0]));
                }
                if (size2 == 2) {
                    list.add(list2.toArray(new Integer[0]));
                }
            } else if(size1 == 4 || size2 == 4) {
                if (size1 == 4) {
                    addToList2(list1, list);
                }
                if (size2 == 4) {
                    addToList2(list2, list);
                }
            } else if(size1 == 3 || size2 == 3) {
                if (size1 == 3) {
                    addToList2(list1, list);
                }
                if (size2 == 3) {
                    addToList2(list2, list);
                }
            }
        } else if(needNum == 4) {
            if (size1 == 4) {
                list.add(list1.toArray(new Integer[0]));
            }
            if (size2 == 4) {
                list.add(list2.toArray(new Integer[0]));
            }
        }
        System.out.println(JSON.toJSONString(list));
    }

    private static void addToList2(List<Integer> list, List<Integer[]> allList) {
        int size = list.size();
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                Integer[] arrays = new Integer[2];
                arrays[0] = list.get(i);
                arrays[1] = list.get(j);
                allList.add(arrays);
            }
        }
    }

    private static void addToList1(List<Integer> list, List<Integer[]> allList) {
        for(Integer no : list) {
            Integer[] arrays = new Integer[1];
            arrays[0] = no;
            allList.add(arrays);
        }
    }


}
