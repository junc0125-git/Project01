package com.unit09.string.transform;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author cj
 * @create 2020-10-27 20:21
 *
 *      String与字节数组的转换
 *      String与字符数组的转换
 *      String与基本数据类型的转换
 */
public class StringTransformTest {
    ////////////////////*****************   String与字节数组的转换  ***********//////////////////////////////
    /*
         字节数组  字符串
            String(byte[])：通过使用平台的默认字符集解码指定的 byte 数组，构
        造一个新的 String。
            String(byte[]，int offset，int length) ：用指定的字节数组的一部分，
        即从数组起始位置offset开始取length个字节构造一个字符串对象。

         字符串  字节数组
            public byte[] getBytes() ：使用平台的默认字符集将此 String 编码为
        byte 序列，并将结果存储到一个新的 byte 数组中。
            public byte[] getBytes(String charsetName) ：使用指定的字符集将 此 String 编码到 byte 序列，
        并将结果存储到新的 byte 数组。
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1="hello!中国";
        //编码
        byte[] b1=s1.getBytes();
        System.out.println(Arrays.toString(b1));// a:97 [104, 101, 108, 108, 111, 33, -28, -72, -83, -27, -101, -67]
        //解码
        String s2=new String(b1);
        System.out.println(s2);//hello!中国
        String s3=new String(b1,6,6);
        System.out.println(s3);//中国

        byte[] b2=s1.getBytes("gbk");//不同形式的编码中文编码结果不同
        System.out.println(Arrays.toString(b2));//[104, 101, 108, 108, 111, 33, -42, -48, -71, -6]
        String s4=new String(b2);
        System.out.println(s4);//hello!�й�  乱码，因为编码和解码格式不同
        String s5=new String(b2,"gbk");
        System.out.println(s5);//hello!中国

    }

    ////////////////////*****************   String与字符数组的转换  ***********//////////////////////////////
    /*
         字符数组  字符串
            String 类的构造器：String(char[]) 和 String(char[]，int offset，int
        length) 分别用字符数组中的全部字符和部分字符创建字符串对象。

         字符串  字符数组
            public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组
        中的方法。
            public void getChars(int srcBegin, int srcEnd, char[] dst,
        int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法。
     */
    @Test
    public void test2() {
//        字符数组  字符串  ：  调用String 类的构造器
        char[] c1 = {'a', 'b', 'c'};
        String s1=new String(c1);
        System.out.println(s1);

//        字符串  字符数组  : 1) char[] toCharArray()  2) void getChars(int srcBegin, int srcEnd, char[] dst,
//        int dstBegin)
        System.out.println("******************");
//        1) char[] toCharArray()
        char[] c2=s1.toCharArray();
        System.out.println(c2);//char内有一个一定量的遍历器，可以直接输出
//        2) void getChars(int srcBegin, int srcEnd, char[] dst,int dstBegin)
        System.out.println("********************************");
        char[] c3= {'1','2','3'};
        s1.getChars(0,s1.length()-1,c3,1);//1ab  左闭右开  如果超出数组长度，会报越界异常
//        s1.getChars(0,s1.length(),c3,1);//越界异常  如果超出数组长度，会报越界异常
        System.out.println(c3);
    }

        ////////////////////************    String与基本数据类型的转换    ***********//////////////////////////////
    /*
        字符串  基本数据类型、包装类   ： 包装类.parseInt(String)  -->  int类型变量
        基本数据类型、包装类  字符串    :   调用String类的public String valueOf(int n)可将int型转换为字符串

        字符串  基本数据类型、包装类
            Integer包装类的public static int parseInt(String s)：可以将由“数字”字
        符组成的字符串转换为整型。
            类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应
        的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。
        基本数据类型、包装类  字符串
            调用String类的public String valueOf(int n)可将int型转换为字符串
            相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double
        d)、valueOf(boolean b)可由参数的相应类型到字符串的转换
    */
    @Test
    public void test1() {
        //  Integer包装类的public static int parseInt(String s)
        String s1 = "123";
        int num1 = Integer.parseInt(s1);
        System.out.println(num1);

//        调用String类的public String valueOf(int n)可将int型转换为字符串
        int num2 = 123;
        String s2 = String.valueOf(num2);
        System.out.println(s2);

    }
}
