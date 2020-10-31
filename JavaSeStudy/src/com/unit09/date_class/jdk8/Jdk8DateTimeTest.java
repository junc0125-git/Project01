package com.unit09.date_class.jdk8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author cj
 * @create 2020-10-29 14:20
 *
 * JDK 8 中日期时间的API测试
 *      1，LocalDate、LocalTime、LocalDateTime  有不可变性  获取的都是当地的日期时间
 *          now(): 获取当前的日期，时间，日期和时间 对象（静态方法，获取的是一个对象）
 *          of():设置指定的年、月、日、时、分、秒。没有偏移量    不可变性：将设置后的值赋值给一个新的对象，原对象的值不变
 *          getXxx()：获取相关的属性
 *          withXxx():设置相关的属性
 *          plusXxxx(): 原有的基础上加一个数
 *          minusXxxx()：原有的基础上减一个数
 *
 *      2，Instant的使用 ：时间线上的一个瞬时点   类似于 java.util.Date类  都是基准本初子午线的标准时间
 *          now():获取本初子午线（伦敦时间）对应的标准时间
 *          atOffset(): 根据时区，添加时间的偏移量  北京时间：8
 *          toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
 *          ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
 *
 *      3，DateTimeFormatter:格式化或解析日期、时间     类似于SimpleDateFormat
 *          format(): 格式化，日期 --> 字符串
 *          parse(): 解析，字符串 --> 日期
 *          *****   重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
 *
 *
 */
public class Jdk8DateTimeTest {

    ////////////////////////////////        LocalDate、LocalTime、LocalDateTime的使用       /////////////////////////////
    /*
         LocalDate、LocalTime、LocalDateTime ： 当地的日期时间
     */
    @Test
    public void test1() {

        //now(): 获取当前的日期，时间，日期和时间 对象（静态方法，获取的是一个对象）
        System.out.println("*******************     now() 函数测试   ************************");
        LocalDate localDate = LocalDate.now();//获取当前的日期
        LocalTime localTime = LocalTime.now();//获取当前的时间
        LocalDateTime localDateTime = LocalDateTime.now();//获取当前的日期和时间

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("*******************     of() 函数测试   ************************");
        //of():设置指定的年、月、日、时、分、秒。没有偏移量    将设置后的值赋值给一个新的对象，原对象的值不变
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        System.out.println("*******************     getXxx() 函数测试   ************************");
        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        System.out.println("*******************     withXxx() 函数测试   ************************");
        //体现不可变性     在现有对象的基础上进行修改，修改后的值赋给新建的对象，原对象的值不变
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);//localDate调用函数，在localDate的基础上做修改
        System.out.println(localDate);//原对象localDate的值没有改变
        System.out.println(localDate1);//修改后的值赋给了新对象localDate1

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);//原对象localDate的值没有改变
        System.out.println(localDateTime2);//修改后的值赋给了新对象localDate2

        System.out.println("*******************     plusXxxx() 函数测试   ************************");
        //不可变性
        //plusXxxx(): 原有的基础上加一个数
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        System.out.println("*******************     minusXxxx() 函数测试   ************************");
        //minusXxxx()：原有的基础上减一个数
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    ////////////////////////////////        Instant的使用       ///////////////////////////////
    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void test2() {

        System.out.println("*******************     now() 函数测试   ************************");
        //now():获取本初子午线（伦敦时间）对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-10-29T06:55:51.625Z

        System.out.println("*******************     atOffset() 函数测试   ************************");
        //atOffset(): 根据时区，添加时间的偏移量  北京时间：8
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-10-29T14:55:51.625+08:00

        System.out.println("*******************     toEpochMilli() 函数测试   ************************");
        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1603954551625    都是以当前时刻对应的伦敦时间（本初子午线对应的标准时间）为基准

        System.out.println("*******************     ofEpochMilli() 函数测试   ************************");
        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1603954551625L);
        System.out.println(instant1);//2020-10-29T06:55:51.625Z    时间戳转换的也是伦敦时间（本初子午线对应的标准时间）

    }

    ////////////////////////////////        DateTimeFormatter的使用       ///////////////////////////////
         /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    public void test3() {
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2019-02-18T15:42:18.797

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2019年2月18日 下午03时47分16秒


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18


//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);


    }
}
