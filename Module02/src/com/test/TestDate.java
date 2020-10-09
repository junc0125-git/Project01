package com.test;

/**
 * @author cj
 * @date 2020/7/25 - 22:21
 */
public class TestDate {
//    模板1：主函数  psvm
    public static void main(String[] args) {
//    模板2：输出  sout
        System.out.println("输出sout");
//        模板3：循环  fori
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
//        变形：iter
        String[] arr=new String[]{"aaa","bbb","ccc"};
        for (String s : arr) {
            System.out.println(s);
        }
//        变形：itar
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }
    }
}
