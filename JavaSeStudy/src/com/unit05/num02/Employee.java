package com.unit05.num02;

/**
 * @author cj
 * @create 2020-10-01 16:56
 *
 * 2）Employee类中的属性有：办公室office（String类型），工资wage（double
 * 类型），受雇日期hiredate（String类型）；
 */
public class Employee extends Person{
    private String office;//办公室
    private double wage;//工资
    private String hiredate;//受雇日期

    public Employee() {
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }


}
