package com.unit05.num02;

/**
 * @author cj
 * @create 2020-10-01 20:53
 *
 * 5）现有对象Person p1 =new Faculty()和Person p2 =new Staff ()，请
 * 分别为p1的属性赋值“本科”和Staff类的duty赋值“职员”
 */
public class Test {
    public static void main(String[] args) {
        Person p1 =new Faculty();
        Person p2 =new Staff ();
        p1.setAttribute("本科");
        System.out.println(p1.getAttribute());
        p2.setAttribute("职员");
        System.out.println(p2.getAttribute());
        System.out.println(p1.getAttribute());

    }
}
