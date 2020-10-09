package com.unit05.num02;

/**
 * @author cj
 * @create 2020-10-01 20:48
 *
 * 3）Faculty类中的属性有：学位degree（String类型），级别level（String类型）；
 */
public class Faculty extends Employee{
    private String degree;//学位
    private String level;//级别

    public Faculty() {
    }

    public void setAttribute(String para) {
        this.degree = para;
    }

    public String getAttribute(){
        return this.degree;
    }



    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
