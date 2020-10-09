package com.day01;

/**
 * @author cj
 * @create 2020-09-27 19:10
 * 数组赋值练习1
 * 创建一个char类型的26个元素的数组，分别 放置'A'-'Z'。
 * 使用for循环访问所有元素并打印出来。
 */
public class ArrayAssignmentTest01 {
    public static void main(String[] args) {

        /*
         * 如果其中有一个是变量，按照自动类型转换规则处理成一致的类型；
         * 如果都是常量，如果一个是char，如果另一个是[0~65535]之间的整数按char处理；
         * 			如果一个是char，另一个是其他，按照自动类型转换规则处理成一致的类型；
         */
        char x = 'x';
        int i = 10;
        System.out.println(true ? x : i);//120
        System.out.println(true ? 'x' : 10);//x

        int cr = x + 1;
        System.out.println("cr"+cr);//cr: 121
        System.out.println(x + 1);//121

        System.out.println('x' + 1);//121
        char r = 'x' + 1;
        System.out.println(r);//y
        System.out.println('x' + 1.0);//121.0
        char r1 = (char) ('x' + 1.0);
        System.out.println("r1:" + r1);//r1: y
        double d = 'x' + 1.0;
        System.out.println(d);//121.0


        char[] letter = new char[26];
        for (i = 0; i < letter.length; i++) {
            //letter[i]='A'+i;//当有变量参加运算时，进行自动类型转化
            letter[i] = (char) ('A' + i);
            //char型常量与整型常量一起时，转为char型常量

//            char型常量与其他类型常量一起时，转为其他类型
//            System.out.println(letter[i]);
        }
        for (i = 0; i < letter.length; i++) {
            System.out.println(letter[i]);
        }

    }
}
