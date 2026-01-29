package Sample.Q2;

public class BankAccount {
    private int balance = 1000;

    void withdraw(int amount){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" is trying to withdraw "+amount);
            if(balance>=amount){
                System.out.println(Thread.currentThread().getName()+" is processing withdrawl...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                balance -=amount;
                System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance: "+balance);
            }
            else{
                System.out.println(Thread.currentThread().getName()+"- insufficient balance!");
            }
        }
    }
}
