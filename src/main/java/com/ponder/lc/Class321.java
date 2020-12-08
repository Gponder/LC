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
 *
 * 找A数组最大值
 * 找B数组最大值
 * 比较AB最大值
 * A>B    A<B     A=B
 * 校验长度是否合格
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
        return nums1;
    }

    private void findMaxNum(int[] nums1,int start1,int[] nums2,int start2,int[] result,int index){
        int temp = nums1[start1];
        boolean flag;
        for (int i=start1;i<nums1.length;i++){
            if (temp<nums1[i]){
                temp = nums1[i];
                flag = true;
                start1 = i;
            }
        }
        for (int j=start2;j<nums2.length;j++){
            if (temp<nums2[j]){
                temp = nums2[j];
                flag = false;
                start2 = j;
            }
        }
        if (nums1.length-start1+nums2.length-start2 >= result.length - index){
            result[index] = temp;
            findMaxNum(nums1,start1,nums2,start2,result,index++);
        }else{

        }
    }

    /**
     *
     * @param arr
     * @param index  开始下表
     * @return
     */
    private int getMaxIndex(int[] arr,int index){
        if (index>=arr.length)return -1;
        int temp=arr[index];
        for (int i = index;i<arr.length;i++){
            if (temp<arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param k     剩余长度
     * @param start1    数组1开始位置
     * @param start2    数组2开始位置
     */
    private void un(int[] nums1, int[] nums2, int k,int[] result,int start1,int start2){
        int indexA = getMaxIndex(nums1, start1);
        int indexB = getMaxIndex(nums2, start2);
        if ((indexA!=-1)&&(indexB==-1 || nums1[indexA]>nums2[indexB])){
            a(nums1, nums2, k, result, start1, start2, indexA);
        }else if ((indexB!=-1)&&(indexA==-1||(nums1[indexA]<nums2[indexB]))){
            b(nums1, nums2, k, result, start1, start2, indexA, indexB);
        }else if (indexA!=-1&&indexB!=-1&&nums1[indexA]==nums2[indexB]){
            a(nums1, nums2, k, result, start1, start2, indexA);
        }
    }

    private void b(int[] nums1, int[] nums2, int k, int[] result, int start1, int start2, int indexA, int indexB) {
        if (nums1.length-indexA+nums2.length-start1>=0){
            if (k>0){
                result[result.length-k]=nums2[indexB];
                un(nums1,nums2,k-1,result,start1,indexB+1);
            }
        }else {
            int[] nums22 = Arrays.copyOf(nums2,nums2.length);
            nums22[indexB] = -1;
            un(nums1,nums22,k,result,start1,start2);
        }
    }

    private void a(int[] nums1, int[] nums2, int k, int[] result, int start1, int start2, int indexA) {
        if (nums1.length-indexA+nums2.length-start2>=0){
            if (k>0){
                result[result.length-k]=nums1[indexA];
                un(nums1,nums2,k-1,result,indexA+1,start2);
            }
        }else {
            int[] nums11 = Arrays.copyOf(nums1, nums1.length);
            nums11[indexA] = -1;
            un(nums11,nums2,k,result,start1,start2);
        }
    }

    public void aOrB(int[] a,int[] b){

    }

    public void test1(){
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int[] result = new int[5];
        try {
            un(nums1,nums2,5,result,0,0);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(result));
    }

    private void test2(){
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{6, 0, 4};
        int[] result = new int[5];
        un(nums1,nums2,5,result,0,0);
        System.out.println(Arrays.toString(result));
    }

    private void test3(){
        int[] nums1 = new int[]{3, 9};
        int[] nums2 = new int[]{8, 9};
        int[] result = new int[3];
        un(nums1,nums2,3,result,0,0);
        System.out.println(Arrays.toString(result));
    }

    public void test(){
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int[] arr = maxNumber(nums1, nums2, 5);
        int index = getMaxIndex(nums1,0);
        System.out.println(index);
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        Class321 class321 = new Class321();
//        class321.test1();
//        class321.test2();
        class321.test3();
    }
}
