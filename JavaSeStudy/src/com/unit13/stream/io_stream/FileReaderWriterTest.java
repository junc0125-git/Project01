package com.unit13.stream.io_stream;

import org.junit.Test;

import java.io.*;

/**
 *
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *      注：处理流是对已有的节点流进行包装
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *      注：缓冲流就是为了提高文件的读写效率，开发中都用缓冲流
 *   无论字符流还是字节流都是使用read()和write()函数
 *
 *
 * @author shkstart
 * @create 2019 上午 10:40
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }


    /*
    文件流的操作步骤：
        1.实例化File类的对象，指明要操作的文件
        2.提供具体的流（读入流/写出流）
        3.数据的读入/写出
        4.流的关闭操作    一定要关闭

    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。
     */


////////////////////////   文件流的读入：FileReader  从文件读入 /////////////////////////////
    @Test
    public void testFileReader(){
        FileReader fr = null;//此处是异常处理自动生成移到括号外的，因为经过异常处理，流的关闭到了另一个括号内
        try {
     //1.实例化File类的对象，指明要操作的文件
            File file = new File("src/com/unit13/file_test/hello.txt");//相较于当前Module
     //2.提供具体的流
            fr = new FileReader(file);
   //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();//data存的是返回字符的ASCII码
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }

            //方式二：语法上针对于方式一的修改
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while((data = fr.read()) != -1){//data存的是返回字符的ASCII码
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

   //4.流的关闭操作    一定要关闭
//            try {
//                if(fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //或
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //对read()操作升级：使用read的重载方法
    // read(char[] cbuf)：每次将读入的字符存到char数组中，返回读入的字符数
    @Test
    public void testFileReader1()  {
        FileReader fr = null;
        try {
            //1.File类的实例化    创建文件对象
            File file = new File("src/com/unit13/file_test/hello.txt");

            //2.FileReader流的实例化     创建流的对象
            fr = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //方式一：
                //错误的写法    最后一次可能读取不到字符数组长度的数据
//                for(int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);//helloword123ld
//                }
                //正确的写法   len: 获取的是每次读取的字符数
//                for(int i = 0;i < len;i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：  char[]数组  -->  字符串
                //错误的写法,对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);//helloword123ld
                //正确的写法
                String str = new String(cbuf,0,len);//从0开始 len个长度的字符转为字符串
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                //4.资源的关闭  一定要关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


 ////////////////////////     文件流的写出：FileWriter     写出到文件 /////////////////////////////
    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在： ture；添加    false：不添加（覆盖）    默认为 false
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件     写出时，如果文件不存在，会自动创建
            File file = new File("src/com/unit13/file_test/hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,false);//false: 表示不采用添加的方式写入，即采用覆盖

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if(fw != null){

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   }



 ////////////////////////     文件流的读入与写出：FileWriter   FileReader    /////////////////////////////
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("src/com/unit13/file_test/hello.txt");
            File destFile = new File("src/com/unit13/file_test/hello2.txt");

            //不能使用 *字符流* 来处理图片等 *字节数据*
//            File srcFile = new File("src/com/unit13/file_test/爱情与友情.jpg");
//            File destFile = new File("src/com/unit13/file_test/爱情与友情1.jpg");


            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);


            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);//从0开始，每次写入len个长度

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
