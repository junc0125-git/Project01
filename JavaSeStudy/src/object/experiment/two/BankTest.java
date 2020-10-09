package object.experiment.two;

/**
 * @author cj
 * @create 2020-09-24 17:12
 */
public class BankTest {
    public static void main(String[] args){
        Bank bk = new Bank();
        bk.addCustomer("chen","jun");
        int number = bk.getNumberOfCustomers();
        Customer ct = bk.getCustomer(0);
        System.out.println(ct.getFirstName()+ct.getLastName());

    }

}
