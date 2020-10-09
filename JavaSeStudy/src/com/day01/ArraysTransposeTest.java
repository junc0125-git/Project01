package com.day01;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-09-27 19:55
 *
 * 一维数组a[]，用java代码将数组元素顺序颠倒
 */
public class ArraysTransposeTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        System.out.println("转置前"+Arrays.toString(a));
        ArraysTransposeTest at = new ArraysTransposeTest();
        at.swap(a);
        System.out.println("转置后"+Arrays.toString(a));
    }
    public void swap(int[] nums){
        int low,hight,temp;
        low=0;
        hight=nums.length-1;
        while(hight>low){
            temp=nums[low];
            nums[low]=nums[hight];
            nums[hight]=temp;
            low++;
            hight--;
        }
    }
}
//同一个文件中只能有一个定义成public的类，且类名要与文件名相同
