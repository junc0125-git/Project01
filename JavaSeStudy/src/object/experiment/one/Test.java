package object.experiment.one;

/**
 * @author cj
 * @create 2020-09-24 15:41
 *
 * 3.写一个测试程序。
 * （1） 创建一个 Customer ，名字叫 Jane Smith, 他有一个账号为 1000，余额为 2000 元，
 * 年利率为 1.23％ 的账户。
 * （2） 对 Jane Smith 操作。
 * 存入 100 元，再取出 960 元。再取出 2000 元。
 * 打印出 Jane Smith 的基本信息
 * 尚硅谷 Java 基础编程 宋红康
 * 成功存入 ：100.0
 * 成功取出：960.0
 * 余额不足，取款失败
 * Customer [Smith, Jane] has a account: id is 1000, annualInterestRate is 1.23％, balance is
 * 1140.0
 */
public class Test {
    public static void main(String[] args){
        Account ac = new Account(1000,2000,1.23);
        Customer ct = new Customer("Jane","Smith");
        ct.setAccount(ac);
        ct.getAccount().deposit(100);
        ct.getAccount().withdraw(960);
        ct.getAccount().withdraw(2000);
        System.out.println("Customer ["+ct.getLastName()+", "+ct.getFirstName()+"] has a account: id is "+
                ct.getAccount().getId()+", annualInterestRate is "+ct.getAccount().getAnnualInterestRate()+
                "％, balance is "+ ct.getAccount().getBalance());
    }


}
