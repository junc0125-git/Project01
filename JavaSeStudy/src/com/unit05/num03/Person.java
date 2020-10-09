package com.unit05.num03;

import java.util.Date;
import java.util.Objects;

/**
 * @author cj
 * @create 2020-10-02 9:08
 *
 * 3,,定义一个person类，属性如下：
 * （1）身份证号，性别，姓名，年龄，户籍，出生日期（Data类型，需要引用java.uitl.Data）功能：
 * （2）自我介绍：介绍格式：（toString）
 * 身份证号+姓名+户籍
 * （3）提供对象比较equals方法，只要身份证号+姓名相同就认为对象相等
 */
public class Person {
    private String identityCard;//身份证号
    private String sex;//性别
    private String name;//姓名
    private int age;//年龄
    private String address;//户籍
    private Date birthday;//生日

    public Person() {
    }

    public Person(String identityCard, String sex, String name, int age, String address) {
        this.identityCard = identityCard;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.address = address;

    }



    public String itself(){
        return identityCard+name+address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(identityCard, person.identityCard) &&
                Objects.equals(name, person.name);
    }



    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
