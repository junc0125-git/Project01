package com.day01;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-09-28 9:18
 * <p>
 * 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 */
public class ArraysMoveTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int m = 3;
        int j=0;
        int n = a.length;
        int[] temp = new int[m];
        System.out.println(Arrays.toString(a));
        for (int i = n - m; i < n; i++) {
            temp[j] = a[i];
            j++;
        }
        for (int i = n-1; i >=m; i--) {
            a[i]=a[i-m];
        }
        System.arraycopy(temp, 0, a, 0, m);
        /*for (int i = 0; i < m; i++) {
            a[i] = temp[i];
        }*/
        System.out.println(Arrays.toString(a));
    }
}
