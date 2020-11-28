package com.unit11.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2019 下午 4:07
 *
 *  Map实现类之五：Properties
 *      Properties 类是 Hashtable 的子类，该对象用于处理属性文件
 *      由于属性文件里的 key、value 都是字符串类型，所以 Properties 里的 key 和 value 都是字符串类型
 *      存取数据时，建议使用setProperty(String key,String value)方法和 getProperty(String key)方法
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("E:\\idea_workspace\\Project01\\JavaSeStudy\\src\\com\\unit11\\map\\jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);//name = cj陈俊, password = 123abc
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
