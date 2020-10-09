package com.unit05.num03;

/**
 * @author cj
 * @create 2020-10-02 9:20
 *
 * private String identityCard;//身份证号
 *     private String sex;//性别
 *     private String name;//姓名
 *     private int age;//年龄
 *     private String address;//户籍
 *     private Date birthday;//生日
 *
 *     提供对象比较equals方法，只要身份证号+姓名相同就认为对象相等
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("341929210190239731","男","章华" ,29,"安徽");
        System.out.println(person.itself());
        Person p1=new Person();
        Person p2=new Person();
        p1.setIdentityCard("12");
        p1.setName("cj");
        p2.setIdentityCard("12");
        p2.setName("cj");
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(person));
        System.out.println(p1==p2);
        p1=person;
        System.out.println(p1==person);
    }
}
