package com.unit07;

/**
 * @author cj
 * @create 2020-10-17 16:18
 *
 * 请编写程序举例抛出一个空指针异常
 * 请编写程序举例抛出一个类型转换异常
 * 请编写程序举例抛出一个数组索引越界异常
 * 请编写程序举例抛出一个索引越界异常
 * 请编写程序举例抛出一个字符串索引越界异常
 * 请编写程序举例说明，在数组索引越界异常中，如果只适用try finally，捕获到的异常不会被处理，程序仍然中断。
 */
public class ExceptionTest {
    public static void main(String[] args) {

//        请编写程序举例抛出一个空指针异常
        String str=null;
        try{
            str.length();
        }catch (NullPointerException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

//        请编写程序举例抛出一个类型转换异常
        /*String a="1";
        try{
            int b=(int)a;
        }catch (Exception e){
            e.printStackTrace();
        }
*/

//        请编写程序举例抛出一个数组索引越界异常

//        请编写程序举例抛出一个索引越界异常
//        请编写程序举例抛出一个字符串索引越界异常
//        请编写程序举例说明，在数组索引越界异常中，如果只适用try finally，捕获到的异常不会被处理，程序仍然中断。

    }
}
