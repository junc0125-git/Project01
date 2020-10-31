package com.unit09.date_class.beforejdk8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author cj
 * @create 2020-10-28 21:33
 *
 * *    jdk 8之前的日期时间的API测试
 *  *       1. System类中currentTimeMillis();
 *  *       2. java.util.Date和子类java.sql.Date
 *  *       3. SimpleDateFormat
 *  *       4. Calendar
 */
public class DateTimeTest01 {

    //////////////////////////////      java.util.Date和子类java.sql.Date      ////////////////////////////////
    /*
        练习一：字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void test2_Exer1() throws ParseException {
        String str="2020-09-08";

        //先解析：--->  Date  型    使用SimpleDateFormat的对象，按固定格式解析
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(str);

        //因为java.sql.Date是java.util.Date的子类，而父类不可强制转换为子类
        //此处借助构造器用时间戳转为sql型Date
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }
    /*
        练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

        举例：2020-09-08 ？ 总天数

        总天数 % 5 == 1,2,3 : 打渔
        总天数 % 5 == 4,0 : 晒网

        总天数的计算？
        方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
        方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */
    @Test
    public void test2_Exer2() throws ParseException {
        System.out.println("请输入日期（格式 xxxx-xx-xx）：");
        Scanner sc=new Scanner(System.in);
        String strIn=sc.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //解析
        Date date1 = format.parse(strIn);
        Date date2 = format.parse("1990-01-01");
        long date=(date1.getTime()-date2.getTime())/(1000*60*60*24)+1;
        switch ((int) (date%5)){
            case 1:
            case 2:
            case 3:
                System.out.println("打渔");
                break;
            case 4:
            case 0:
                System.out.println("嗮网");
                break;
        }


    }

  /////////////////////////////       SimpleDateFormat的使用      ////////////////////////////////////////////
     /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --->字符串  format()
    1.2 解析：格式化的逆过程，字符串 ---> 日期  parse()

    2.SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat：默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();


        Date date = new Date();
        System.out.println(date);//Wed Oct 28 21:42:44 CST 2020

        //格式化：日期 -->  字符串
        String format = sdf.format(date);//格式化返回类型是String
        System.out.println(format);// 格式化后： 20-10-28 下午9:42

        //解析：格式化的逆过程：字符串 -->  日期
        String str="20-10-28 下午9:42";
        Date date1 = sdf.parse(str);
        System.out.println(date1);//Wed Oct 28 21:42:00 CST 2020

        System.out.println("******************************************");

        //指定格式实例化   y:年  M:月  d: 日  h；小时   m: 分钟  s: 秒    (字母的个数对应位数)
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2020-10-28 09:56:08
        //解析: 要求字符串必须是符合相应规格
        Date date2 = sdf1.parse("2020-10-28 09:56:08");
        System.out.println(date2);//Sun Dec 29 09:56:08 CST 2019
    }

    /////////////////////////////       Calendar的使用      ////////////////////////////////////////////
    /*
        Calendar日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){

        //1，实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用静态方法getInstance
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//获取今天是这个月的第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//获取今天是这个年的第几天

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);//将今天设置为这个月的第几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);//增加amount天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
