package LabExercises.Q2;

public class OnlineOrderProcessingSystem extends Thread{
    private String status;
    OnlineOrderProcessingSystem(String status){
        this.status = status;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Current status: "+status);
            try{
                sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Process Interrupted!");
            }
        }
    }
}
