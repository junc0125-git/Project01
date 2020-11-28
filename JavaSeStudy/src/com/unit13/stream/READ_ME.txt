

    一、流的分类
        按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
        按数据流的流向不同分为：输入流，输出流
        按流的角色的不同分为：节点流，处理流

            (抽象基类)      字节流             字符流
              输入流       InputStream       Reader
              输出流       OutputStream      Writer

        1. Java的IO流共涉及40多个类，实际上非常规则，都是从如下4个
            抽象基类派生的。
        2. 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。



    二、流的体系结构   字符流   字节流   （注：开发一般用缓冲流，因为读写速度快，效率高）
     * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
     * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
     * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
     * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
     * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()

        无论字符流还是字节流都是使用read()和write()函数

     结论：
        1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
        2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
        3，文本文件的复制也可以使用字节流处理，
            反之，非文本文件的复制一定不能使用字符流

         使用字节流FileInputStream处理文本文件，可能出现乱码



    三、文件流的操作步骤：
        1.实例化File类的对象，指明要操作的文件
            File file=new File("指定文件路径");
        2.提供具体的流（读入流/写出流）
            FileReader fis=new FileReader(file);
        3.数据的读入/写出
            char[] cbuf=new char[5];
            int len=fis.read(cbuf);//read()函数会返回读取的字符长度    如果到达文件末尾，会返回0
        4.流的关闭操作    一定要关闭
            fis.close();
        注：
            读入：文件  -->  程序
            写出：程序  -->  文件



    四、处理流之一：缓冲流     BufferedTest.java

        1，缓冲流属于处理流，是对已有的节点流进行包装，加快流的读写效率
        字节:
            BufferedInputStream/BufferedOutputStream
        字符：
            BufferedReader/BufferedWriter

         2.作用：提供流的读取、写入的速度
            提高读写速度的原因：内部提供了一个缓冲区

         3. 处理流，就是“套接”在已有的流的基础上

         4. 使用用法
            1，造文件
                File file=new File("文件的指定路径");
            2，造流   节点流和缓冲流是一一对应的
                造节点流
                FileInputStream fis=new FileInputStream(file);
                造缓冲流    缓冲流是处理流的一种，对节点流进行处理
                BufferedInputStream bis=new BufferedInputStream(fis);
            3，进行读写操作
                byte[] bt=new byte[10];
                int len=bis.read(bt);///readLine(): 可以按行读，结尾处返回null
            4，关闭流
                要求：先关闭外层的流，再关闭内层的流
                但是：关闭外层流的同时，内层流也会自动的进行关闭。
                所以：关于内层流的关闭，我们可以省略.
                bis.close();




    五、处理流之二：转换流     InputStreamReaderTest.java
        转换流提供了在字节流和字符流之间的转换

        Java API提供了两个转换流：
             InputStreamReader：将InputStream转换为Reader
             OutputStreamWriter：将Writer转换为OutputStream
            一般文件都是用字节存储

       转换流：属于字符流
          *   InputStreamReader：将一个字节的输入流转换为字符的输入流    输入：文件-->程序  程序中用字符显示
          *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流    输出：程序-->文件   文件中用字节存储
          *   总结：
             *    输入：字节-->字符
             *    输出：字符-->字节

         字节流中的数据都是字符时，转成字符流操作更高效。
         很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能

        代码：
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
         //保存时使用什么编码，解码时必须使用相同的字符集，否则会乱码

        //输入：字节-->字符    将一个  字节的输入流  转换为   字符的输入流
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
         //输出：字符-->字节    将一个  字符的输出流  转换为   字节的输出流
         OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");



    六、其他流的使用：了解内容
       * 1.标准的输入、输出流
       * 2.打印流
       * 3.数据流



    七、处理流之六：对象流

      1，ObjectInputStream和OjbectOutputSteam
        用于存储和读取基本数据类型数据或对象的处理流。
        强大之处：可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

      2，序列化与反序列化
        序列化：对象    -->    数据源
            用ObjectOutputStream类  保存  基本类型数据或对象的机制
        反序列化：数据源  -->     对象
            用ObjectInputStream类  读取  基本类型数据或对象的机制

        注意点：ObjectOutputStream和ObjectInputStream不能序列化static和transient修
                饰的成员变量

       3，对象 序列化机制
            允许把内存中的  Java对象  转换成平台无关的二进制流，从
         而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
         输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
         来的Java对象。

            对象可序列化的条件：如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可
                      序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。
                      否则，会抛出NotSerializableException异常
                            Serializable
                            Externalizable

       4，serialVersionUID
            凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
                private static final long serialVersionUID;
                serialVersionUID用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象
            进行版本控制，有关各版本反序列化时是否兼容。
                如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自
            动生成的。若类的实例变量做了修改，serialVersionUID 可能发生变化。故建议，
            显式声明。

            简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验
            证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的
            serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同
            就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异
            常。(InvalidCastException)


       5，谈谈你对java.io.Serializable接口的理解，我们知道它用于序列化，
        是空方法接口，还有其它认识吗？

             实现了Serializable接口的对象，可将它们转换成一系列字节，并可在以后
            完全恢复回原来的样子。这一过程亦可通过网络进行。这意味着序列化机
            制能自动补偿操作系统间的差异。换句话说，可以先在Windows机器上创
            建一个对象，对其序列化，然后通过网络发给一台Unix机器，然后在那里
            准确无误地重新“装配”。不必关心数据在不同机器上如何表示，也不必
            关心字节的顺序或者其他任何细节。

             由于大部分作为参数的类如String、Integer等都实现了
            java.io.Serializable的接口，也可以利用多态的性质，作为参数使接口更
            灵活。
