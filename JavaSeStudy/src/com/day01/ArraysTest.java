package com.day01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cj
 * @create 2020-09-27 18:49
 * <p>
 * 练习：
 * 1、从键盘输入本组学员的成绩，放到数组中
 * 2、用for循环显示所有学员的成绩
 * 3、排序：从低到高
 * 4、查找是否有正好60分的，如果有返回位置
 * 5、复制成绩最低三名构成新数组
 * 6、用工具类打印成绩最低三名成绩
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] sorce = new int[5];
        System.out.println("请输入5个学员的成绩：");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            sorce[i] = input.nextInt();
        }
        for (int i = 0; i < sorce.length; i++) {
            System.out.println("第" + (i + 1) + "个学员的成绩：" + sorce[i]);
        }
        Arrays.sort(sorce);
        int index=Arrays.binarySearch(sorce,60);
        if(index<0){
            System.out.println("没有正好60分的！返回值为"+index);
        }else {
            System.out.println("60分的索引位置为："+index);
        }
        int[] newArray=Arrays.copyOf(sorce,3);
        System.out.println("成绩最低的三名成绩为："+Arrays.toString(newArray));

    }


}
