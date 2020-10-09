package com.unit06.num04;

/**
 * @author cj
 * @create 2020-10-07 19:39
 */
public class Test {
    public static void main(String[] args) {
        Person student=new Student("小明",18,"男");
        Person teacher=new Teacher("张老师",30,"女");
        System.out.println(teacher.toString());
        teacher.work();
        teacher.hello();
        System.out.println(student.toString());
        student.work();
        student.hello();
    }
}
