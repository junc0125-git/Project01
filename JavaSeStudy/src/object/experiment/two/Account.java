package object.experiment.two;

/**
 * @author cj
 * @create 2020-09-24 16:12
 *
 * 1.按照如下的 UML 类图，创建相应的类，提供必要的结构
 * 在提款方法 withdraw()中，需要判断用户余额是否能够满足提款数额的要求，如果不能，
 * 应给出提示。deposit()方法表示存款。
 */
public class Account {
    private double balance;//存款

    public Account(double init_balance){
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt){//存钱
        if(amt<=0){
            System.out.println("存款金额违规");
        }else{
            this.balance += amt;
            return ;
        }
    }

    public void withdraw(double amt){//取钱
        if(amt>this.balance){
            System.out.println("账户余额不足");
        }else{
            this.balance -= amt;
            System.out.println("已取钱");
            System.out.println("已取钱");
        }
    }
}
