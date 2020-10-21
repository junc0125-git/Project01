package com.unit07;

/**
 * @author cj
 * @create 2020-10-17 16:11
 */
public class Test {
    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            System.out.println("1");
            return result;
        }finally{
            System.out.println("2");
            result = x - y;
            return result;
        }
    }
}
