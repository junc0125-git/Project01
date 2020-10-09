package com.unit04;

/**
 * @author cj
 * @create 2020-09-29 11:16
 */
public class Demo{
    public static void main(String[] args){
        show(0);//15
        show(1);//14  从case1一直往下执行，并且不再做判断
    }
    public static void show(int i){
        switch(i){
            default:
                i+=2;//没有break会一直往下执行，并且不再做case判断
            case 1:
                i+=1;
            case 4:
                i+=8;
            case 2:
                i+=4;

        }
        System.out.println("i="+i);
    }
}
