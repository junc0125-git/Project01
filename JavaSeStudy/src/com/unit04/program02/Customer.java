package com.unit04.program02;

/**
 * @author cj
 * @create 2020-09-28 19:49
 *
 * 其中Customer类有姓名、身份证号、联系电话、家庭地址等属性
 *  *     Customer类有方法say()，返回String类型，返回他的个人信息。
 */
public class Customer {
    private String name;//姓名
    private String identify;//身份证号
    private String tell;//电话
    private String address;//地址

    public Customer(){

    }

    public Customer(String name, String identify, String tell, String address) {
        this.name = name;
        this.identify = identify;
        this.tell = tell;
        this.address = address;
    }

    public String say(){
        return "姓名："+getName()+"身份证号："+getIdentify()+"电话："+getTell()+"地址："+getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
