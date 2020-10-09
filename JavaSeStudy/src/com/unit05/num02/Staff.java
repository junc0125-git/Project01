package com.unit05.num02;

/**
 * @author cj
 * @create 2020-10-01 20:51
 * <p>
 * 4）Staff类中的属性有：职务称号duty（String类型）。
 */
public class Staff extends Employee {
    private String duty;//职务称号

    public Staff() {
    }

    public void setAttribute(String para) {
        this.duty = para;
    }

    public String getAttribute() {
        return this.duty;

    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
