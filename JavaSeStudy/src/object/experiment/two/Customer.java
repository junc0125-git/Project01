package object.experiment.two;

/**
 * @author cj
 * @create 2020-09-24 16:32
 *
 * 2. 按照如下的 UML 类图，创建相应的类，提供必要的结构
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String f,String l){
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
