package Sample.Q3;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producerThread = new Producer(buffer);
        Consumer consumerThread = new Consumer(buffer);
        producerThread.start();
        consumerThread.start();
    }
}
