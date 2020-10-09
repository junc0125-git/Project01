package object.experiment.one;

/**
 * @author cj
 * @create 2020-09-24 15:18
 *
 * 1、写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
 * 账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和 setter
 * 方法），取款方法 withdraw()，存款方法 deposit()。
 * Account
 * private int id
 * private double balance
 * private double annualInterestRate
 * public Account (int id, double balance, double annualInterestRate )
 * public int getId()
 * public double getBalance()
 * public double getAnnualInterestRate()
 * public void setId( int id)
 * public void setBalance(double balance)
 * public void setAnnualInterestRate(double annualInterestRate)
 * public void withdraw (double amount)//取钱
 * public void deposit (double amount)//存钱
 * 提示：在提款方法 withdraw 中，需要判断用户余额是否能够满足提款数额的要求，如果不
 * 能，应给出提示

 */
public class Account {

    private int id;//账户
    private double balance;//余额
    private double annualInterestRate;//年利率

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw (double amount){//取钱
        if(amount>this.balance){
            System.out.println("余额不足，取款失败");
            return ;
        }else{
            this.balance -= amount;
            System.out.println("成功取出"+amount);
        }
    }
    public void deposit (double amount){//存钱
        if(amount<=0){
            System.out.println("存款金额违规！");
        }else {
            this.balance += amount;
            System.out.println("成功存入"+amount);
        }
    }
}
