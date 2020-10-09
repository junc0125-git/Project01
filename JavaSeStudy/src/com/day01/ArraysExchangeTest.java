package com.day01;

import java.util.Scanner;

/**
 * @author cj
 * @create 2020-09-28 17:45
 * <p>
 * 定义一个4行4列的二维数组，逐个从键盘输入值，然后将第1行和第4行的数据进行交换，将第2行和第3行的数据进行交换
 */
public class ArraysExchangeTest {
    public static void main(String[] args) {
        int[][] a = new int[4][4];
        int temp;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4X4数组：");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.print('\n');
        }

        for (int i = 0; i < a[0].length; i++) {
            temp = a[0][i];
            a[0][i] = a[3][i];
            a[3][i] = temp;
            temp = a[1][i];
            a[1][i] = a[2][i];
            a[2][i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.print('\n');
        }


    }
}
