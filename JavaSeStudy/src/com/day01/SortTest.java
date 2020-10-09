package com.day01;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-09-28 8:14
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a={11,22,12,46,43,63,15,64,14,38};
        System.out.println("排序前："+Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序后："+Arrays.toString(a));

    }


}
