package com.ponder.lc;

import java.util.Arrays;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/12/2 17:14
 *
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Class321 {
    /**
     *
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        choseMaxArr(nums1,nums2);
        return nums1;
    }

    private void choseMaxArr(int[] nums1, int[] nums2){
        int i = 0;
        int[] tmp = nums2;
        while (i<nums1.length && i<nums2.length){
            if (findMaxNum(nums1,i)<findMaxNum(nums2,i)){
                nums2 = nums1;
                nums1 = tmp;
                return;
            }
            i++;
        }
        if (nums1.length<nums2.length){
            nums2 = nums1;
            nums1 = tmp;
        }
    }

    private int findMaxNum(int[] arr,int start){
        int max = arr[start];
        for (int i=start+1;i<arr.length;i++){
            if (max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int[] arr = new Class321().maxNumber(nums1, nums2, 5);
        System.out.println(Arrays.toString(arr));
    }
}
