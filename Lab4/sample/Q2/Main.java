package Sample.Q2;

public class Main{
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Customer c1 = new Customer(account,700, "Customer1");
        Customer c2 = new Customer(account,500,"Customer2");
        c1.start();
        c2.start();
    }
}