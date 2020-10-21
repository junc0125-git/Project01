package com.unit07;

/**
 * @author cj
 * @create 2020-10-17 16:15
 */
public class Test01{
    public static void main(String[] args) {
        int[] arr ={1,1,1,1};
        try{
            for(int i = 0 ; i < 5;i++){
                System.out.println(arr[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("这是个异常，不是错误");
        }


    }
}
