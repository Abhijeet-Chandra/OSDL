package Sample.Q3;

public class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.consume();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Consumer sleep interrupted!!!");
            }
        }
    }
}
