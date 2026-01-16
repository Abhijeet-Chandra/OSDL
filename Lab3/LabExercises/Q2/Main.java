package LabExercises.Q2;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        System.out.println("Method 1: By extending Thread class: ");
        OnlineOrderProcessingSystem thread1 = new OnlineOrderProcessingSystem("Order Validation");
        OnlineOrderProcessingSystem thread2 = new OnlineOrderProcessingSystem("Payment Processing");
        OnlineOrderProcessingSystem thread3 = new OnlineOrderProcessingSystem("Order Shipment");
        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();

        System.out.println("Method 2: By implementing Runnable interface: ");
        OnlineOrderProcessingSystem2 task1 = new OnlineOrderProcessingSystem2("Order Validation");
        OnlineOrderProcessingSystem2 task2 = new OnlineOrderProcessingSystem2("Payment Processing");
        OnlineOrderProcessingSystem2 task3 = new OnlineOrderProcessingSystem2("Order Shipment");
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}
