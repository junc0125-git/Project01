package com.unit09.string.exer;

/**
 * @author cj
 * @create 2020-10-27 16:48
 *
 * *****经典面试题：*****  5星推荐
 *
 */
public class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {//引用数据类型传过来的是地址值
        str = "test ok";//String字符串的不可变性  不可更改原地址存储的内容，
                            // 只能新开辟内存存储新字符串，此处全局变量str的地址值并没有改变，
                            // 所以str字符串的内容还是"good"
        System.out.println("方法体内："+str);//方法体内：test ok
        ch[0] = 'b'; }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str);//good
        System.out.println(ex.ch);//best
    } }
