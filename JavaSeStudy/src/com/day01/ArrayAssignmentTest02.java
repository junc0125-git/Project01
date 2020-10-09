package com.day01;

/**
 * @author cj
 * @create 2020-09-27 19:48
 *
 * 数组赋值练习2
 * 创建一个char类型的36个元素的数组，前26个元素放置'A'-'Z',   后10个元素放置'0'-'9'。
 * 使用for循环访问所有元素并打印出来。
 * 提示：char类型数据运算 'A'+1 -> 'B'，'0'+1 -> '1'
 */
public class ArrayAssignmentTest02 {
    public static void main(String[] args) {
        char[] letter=new char[36];
        int j=0;
        for(int i=0;i<26;i++){
            letter[i]= (char) ('A'+i);
        }
        for(int i=26;i<36;i++){

            letter[i]= (char) ('0'+j++);
        }
        for(int i=0;i<36;i++){
            System.out.println(letter[i]);
        }
    }
}
