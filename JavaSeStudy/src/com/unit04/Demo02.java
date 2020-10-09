package com.unit04;

/**
 * @author cj
 * @create 2020-09-30 18:16
 */
public class Demo02{
    public static void main(String[] args){
        int[] a=new int[1];
        System.out.println(a[0]); //0
        modify(a);
        System.out.println(a[0]); //1
    }
    public static void modify(int[] a){
        a[0]++;
    }
}