package com.day01;

/**
 * @author cj
 * @create 2020-09-26 10:43
 */
public class CylinderTest {
    public static void main(String[] args) {
        int[] i=new int[3];
//        float f4[]={1.2F,3.0,5.4};

        Cylinder cld = new Cylinder();
        cld.setRadius(10);
        cld.setLength(10);
        double v = cld.findVolume();
        System.out.println("圆柱的体积为："+v);
    }


}
