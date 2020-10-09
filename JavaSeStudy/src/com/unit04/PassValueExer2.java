package com.unit04;

import java.util.Arrays;

/**
 * @author cj
 * @create 2020-10-01 15:53
 */
public class PassValueExer2{
    public static void main(String[] args){
        int[] array = {3,2,5,1,7};

        //调用sort方法，实现从大到小排序
        //在此处补充代码
        PassValueExer2 pv = new PassValueExer2();
        pv.sort(array);


        //显示结果
        System.out.println("排序后的结果是：" + Arrays.toString(array));
    }

    //要求使用冒泡排序完成
    public void sort(int[] array){
        int i,j,temp;
        for (i=0;i<array.length-1;i++){
            for(j=0;j<array.length-i-1;j++){
                if(array[j]<array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

}
}
