package com.unit09.date.beforejdk8;

import org.junit.Test;

import java.util.Date;

/**
 * @author cj
 * @create 2020-10-28 19:22
 */
public class DateTest {
    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        System.out.println(date.getTime());
        Date date1 = new Date(date.getTime());
        System.out.println(date1.getTime());
        System.out.println(date1.toString());
    }
}
