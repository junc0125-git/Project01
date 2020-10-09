package com.unit04.program01;

/**
 * @author cj
 * @create 2020-09-28 19:42
 */
public class Tset {
    public static void main(String[] args) {
        Husband hd = new Husband();
        Wife wf = new Wife("小红",28,hd);
        hd.setName("小华");
        hd.setAge(30);
        hd.setWife(wf);
        String hdmessage=hd.getInfo();
        System.out.println(hdmessage);
        String wfmessage= wf.getInfo();
        System.out.println(wfmessage);
    }
}
