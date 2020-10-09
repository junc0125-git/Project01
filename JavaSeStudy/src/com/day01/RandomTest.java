package com.day01;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-09-28 8:58
 * <p>
 * 利用随机数生成一个整数数组，数组中有10个元素，每个元素的值都在1-30之间，且要求各个数值不能相同。打印该数组。
 *  Math.random()函数获取的随机数范围是[0.0,1.0)
 * 若想获取一个[a,b]的随机数  -->  (int)(Math.random()*(b-a+1)+a)
 */
public class RandomTest {
    public static void main(String[] args) {
        int[] arrays = new int[10];
        int j;
        for (int i = 0; i < arrays.length; i++) {
            arrays[i]=(int)(Math.random()*30+1);
            j=i-1;
            while(j>=0){
                if(arrays[i]==arrays[j]){
                    arrays[i]=(int)(Math.random()*30+1);
                    j=i;
                }
                j--;
            }

        }
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }


}
