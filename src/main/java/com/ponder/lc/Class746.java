package com.ponder.lc;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/12/21 15:07
 *
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class Class746 {

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            return 0;
        }
    }

    /**
     *
     * @param cost
     * @param i
     * @return
     */
    public int minCostClimbingStairs(int[] cost,int i,int c) {
        System.out.println("i"+i);
        System.out.println("c"+c);
        if (i>=cost.length-2){
            return c;
        }else{
            if (c+cost[i] > c+cost[i+1]){
                c = c+cost[i+1];
                i = i+2;
            }else{
                c = c+cost[i];
                i = i+1;
            }
        }
        return minCostClimbingStairs(cost,i,c);
    }

    public static void main(String[] args) {
        Class746 class746 = new Class746();
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 1, 100};
        int result = class746.minCostClimbingStairs(cost,0,0);
        System.out.println(result);
    }

}
