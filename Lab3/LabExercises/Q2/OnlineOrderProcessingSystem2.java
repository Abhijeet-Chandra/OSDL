package LabExercises.Q2;

import static java.lang.Thread.sleep;

public class OnlineOrderProcessingSystem2 implements Runnable{
    private String status;
    OnlineOrderProcessingSystem2(String status){
        this.status = status;
    }

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
