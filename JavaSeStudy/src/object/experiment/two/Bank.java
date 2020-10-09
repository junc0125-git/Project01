package object.experiment.two;

/**
 * @author cj
 * @create 2020-09-24 16:35
 *
 * 3. 按照如下的 UML 类图，创建相应的类，提供必要的结构
 *  addCustomer 方法必须依照参数（姓，名）构造一个新的 Customer
 * 对象，然后把它放到 customer 数组中。还必须把
 * numberOfCustomer 属性的值加 1。  getNumOfCustomers
 * 方法返回 numberofCustomers 属性值。
 * 尚硅谷 Java 基础编程 宋红康
 *  getCustomer 方法返回与给出的 index 参数相关的客户。
 * 4. 创建 BankTest 类，进行测试。
 */
public class Bank {
    private Customer[] customers = new Customer[10];
    private int numberOfCustomer;

    public Bank() {
    }

    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberOfCustomer] = cust;
        numberOfCustomer++;

    }

    public int getNumberOfCustomers(){
        return numberOfCustomer;
    }

    public Customer getCustomer(int index){
        return customers[index];

    }


}
