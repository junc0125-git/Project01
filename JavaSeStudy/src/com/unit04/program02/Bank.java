package com.unit04.program02;

/**
 * @author cj
 * @create 2020-09-28 19:49
 * <p>
 * 在测试类Bank中创建银行账户类对象和用户类对象，并设置信息，与显示信息
 */
public class Bank {
    public static void main(String[] args) {
        Customer customer = new Customer("张军", "341688188908675420", "18878568818", "苏州");
        Account account = new Account();
        account.setCid(102);
        account.setBalance(10000.1);
        account.setCustomer(customer);
        //显示客户信息
        String customerSay = customer.say();
        System.out.println(customerSay);
        //显示详细账号信息
        String getAccountInfo = account.getInfo();
        System.out.println(getAccountInfo);
        //存款
        boolean isSave = account.save(888.7);

        //取款
        boolean isWithdraw = account.withdraw(10000);


    }
}
