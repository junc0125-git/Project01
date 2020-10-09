package essay.array;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-09-25 18:06
 *
 * # 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Num88Test {
    public static void main(String[] args){
        int[] s1=new int[]{1,2,3,4};
        int[] s2 = new int[]{7,8,9};
        System.arraycopy(s2,1,s1,2,2);
        for(int i=0;i<s1.length;i++){
            System.out.println(s1[i]);
        }

    }
}
class Num88Solution {//解法二：先合并，在排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
/*
class Num88Solution {//方法一：暴力尾插法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        if(m==0){
            for(j=0;j<n;j++){
                nums1[j]=nums2[j];
            }
            return;
        }
        for(j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(nums2[j]<nums1[i]){
                    nums1[i+1]=nums1[i];
                    nums1[i]=nums2[j];
                }else{
                    nums1[i+1] = nums2[j];
                    break;
                }
            }
            m += 1;
        }
    }
}*/

