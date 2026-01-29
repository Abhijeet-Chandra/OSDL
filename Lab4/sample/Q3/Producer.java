package Sample.Q3;

public class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            buffer.produce(i);
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Producer sleep interrupted!!");
            }
        }
    }
}
