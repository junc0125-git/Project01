package com.unit04.program02;

/**
 * @author cj
 * @create 2020-09-28 19:49
 * <p>
 * 编程题2
 * 定义银行账户类Account，有属性：卡号cid，余额balance，所属用户Customer
 * 银行账户类Account有方法：
 * （1）getInfo()，返回String类型，返回卡的详细信息
 * （2）取钱方法withdraw()，参数自行设计，如果取钱成功返回true，失败返回false
 * （3）存钱方法save()，参数自行设计，如果存钱成功返回true，失败返回false
 * <p>
 * 其中Customer类有姓名、身份证号、联系电话、家庭地址等属性
 * Customer类有方法say()，返回String类型，返回他的个人信息。
 * <p>
 * 在测试类Bank中创建银行账户类对象和用户类对象，并设置信息，与显示信息
 */
public class Account {
    private int cid;
    private double balance;
    private Customer customer;

    public Account() {

    }

    public String getInfo() {
//        1）getInfo()，返回String类型，返回卡的详细信息
        return "账号：" + getCid() + "  余额：" + getBalance() +  getCustomer().say();
    }

    //    2）取钱方法withdraw()，参数自行设计，如果取钱成功返回true，失败返回false
    public boolean withdraw(double number) {
        if (number > balance) {
            System.out.println("余额不足");
            return false;
        } else {
            balance -= number;
            System.out.println("取钱成功,当前余额："+balance);
            return true;
        }
    }

    // * （3）存钱方法save()，参数自行设计，如果存钱成功返回true，失败返回false
    public boolean save(double number) {
        if (number <= 0) {
            System.out.println("请放入钱币!");
            return false;
        } else {
            balance += number;
            System.out.println("存钱成功！当前余额："+balance);
            return true;
        }
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
