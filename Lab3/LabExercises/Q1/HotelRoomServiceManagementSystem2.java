package LabExercises.Q1;

import static java.lang.Thread.sleep;
//Method 2 -> by implementing Runnable interface..
public class HotelRoomServiceManagementSystem2 implements Runnable{

    private String serviceType;
    public HotelRoomServiceManagementSystem2(String serviceType){
        this.serviceType = serviceType;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("service: "+serviceType);
            try{
                sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Service interrupted!");
            }
        }
    }
}
