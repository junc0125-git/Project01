package com.day01;

import java.util.Scanner;

/**
 * @author cj
 * @create 2020-09-28 8:19
 * <p>
 * <p>
 * 求一个3*3矩阵对角线元素之和
 * <提示>
 * 程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
 */
public class SumMatrixTest {
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        int sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组元素：");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
        }
        System.out.println("对角线元素之和为："+sum);
    }
}
