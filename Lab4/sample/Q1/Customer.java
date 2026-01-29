package Sample.Q1;

public class Customer extends Thread{
    private BankAccount account;
    private int amount;
    Customer(BankAccount account, int amount, String name){
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
