package com.day01;

import java.util.Scanner;

/**
 * @author cj
 * @create 2020-09-28 8:26
 * <p>
 * 任意一个人输入年龄，就可以判断出他是哪个年龄段的人？
 * <p>
 * /*
 * 0-9   儿童
 * 10-19 少年
 * 20-29 青少年
 * 30-39 青年
 * 40-49 壮年
 * 50-59 中年
 * 60-69 中老年
 * 70-79 老年
 * 80-89 老老年
 * 90-99 老老老年
 */

public class SwitchCaseTest {
    public static void main(String[] args) {
        int age;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年龄：");
        age=input.nextInt();
        switch (age/10){
            case 0:
                System.out.println("儿童");
                break;//如果没有break的话，后面的case将不再判断，直接输出
            case 1:
                System.out.println("少年");
                break;
            case 2:
                System.out.println("青少年");
                break;
            case 3:
                System.out.println("青年");
                break;
            default:
                System.out.println("老了老了");
                break;
        }
    }
}
