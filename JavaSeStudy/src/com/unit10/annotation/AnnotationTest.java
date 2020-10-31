package com.unit10.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的使用
 *
    1. 理解Annotation:注解
        ① jdk 5.0 新增的功能

        ② Annotation: 注解，与反射联用
            其实就是代码里的特殊标记，这些标记可以在编译, 类加载, 运行时被读取（通过反射读取）,
            并执行相应的处理。通过使用 Annotation,程序员可以在不改变原有逻辑的情况下,
            在源文件中嵌入一些补充信息（一些新功能）。

        ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
        中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
        代码和XML配置等。

   2. Annocation的使用示例
        示例一：生成文档相关的注解
        示例二：在编译时进行格式检查(JDK内置的三个基本注解)
            @Override: 限定重写父类方法, 该注解只能用于方法   会在编译阶段就校验重写是否正确
            @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。
                通常是因为所修饰的结构危险或存在更好的选择
            @SuppressWarnings: 抑制编译器警告
        示例三：跟踪代码依赖性，实现替代配置文件功能

    3. 如何自定义注解：参照@SuppressWarnings定义      注解和类，接口，枚举为并列结构
      * ① 注解声明为：@interface    和interface接口没有任何关系
      * ② 内部定义成员，通常使用value表示
      * ③ 可以指定成员的默认值，使用default定义
      * ④ 如果自定义注解没有成员，表明是一个标识作用。

     如果注解有成员，在使用注解时，需要指明成员的值。
     自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
     自定义注解通过都会指明两个元注解：Retention、Target

     4. jdk 提供的4种元注解
        元注解：对现有的注解进行解释说明的注解
            Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
                只有声明为RUNTIME生命周期的注解，才能通过反射获取。
            Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
        *******出现的频率较低*******
            Documented:表示所修饰的注解在被javadoc解析时，保留下来。
            Inherited:被它修饰的 Annotation 将具有继承性。  即注解也会被子类继承

     5.通过反射获取注解信息 ---到反射内容时系统讲解

     6. jdk 8 中注解的新特性：可重复注解、类型注解
        6.1 可重复注解：
            ① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
            ② MyAnnotation的Target,Retention等元注解与MyAnnotations相同。
            ③ MyAnnotations注解里声明一个MyAnnotation数组
                即：MyAnnotation[] value();
            ④ 此时MyAnnotation便可重复使用修饰同一个内容了

        6.2 类型注解：      将这两个加到@Target注解中，那么@Target所修饰的注解的使用范围就又扩大了
            ElementType.TYPE_PARAMETER 表示该注解能写在 *类型变量的声明语句* 中（如：泛型声明）。
            ElementType.TYPE_USE 表示该注解能写在使用 *类型的任何语句* 中。

      *
 * @author shkstart
 * @create 2019 上午 11:37
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        //@SuppressWarnings: 抑制编译器警告
        // 定义一个变量如果没有使用，编译器会警告，用了该注解后，便不会再发出警告
        @SuppressWarnings("unused")
        int num = 10;

//        System.out.println(num);

        //@SuppressWarnings: 抑制编译器警告   rawtypes：是关于  <泛型>  的警告
        @SuppressWarnings({ "unused", "rawtypes" })
        ArrayList list = new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(int i = 0;i < annotations.length;i++){
            System.out.println(annotations[i]);
        }
    }
}


//可重复注解
// jdk 8之前的写法：
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
//jdk 8以及之后的写法：
@MyAnnotation(value="hi")
@MyAnnotation(value="abc")
class Person{
    private String name;
    private int age;

    public Person() {
    }
    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{

    // @Override: 限定重写父类方法, 该注解只能用于方法   会在编译阶段就校验重写是否正确
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    //注解之所以能用在这么多地方，是因为在@Target注解中添加了新的元素：TYPE_PARAMETER,TYPE_USE
    //TYPE_PARAMETER：表示该注解能写在 *类型变量的声明语句* 中（如：泛型声明）
    // TYPE_USE：表示该注解能写在使用 *类型的任何语句* 中

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }

}