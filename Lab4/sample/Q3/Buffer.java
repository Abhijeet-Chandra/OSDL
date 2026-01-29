package Sample.Q3;

public class Buffer {
    private int data;
    private boolean available = false;

    synchronized void produce(int val){
        while(available){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer Thread interrupted!!");
            }
        }
        data = val;
        available = true;
        System.out.println("Produced data: "+data);
        notify();
    }

    synchronized int consume(){
        while(!available){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer Thread interrupted!!");
            }
        }
        available = false;
        System.out.println("Consumed data: "+data);
        notify();
        return data;
    }
}
