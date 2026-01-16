package LabExercises.Q1;
//Method 1-> by extending thread class...
public class HotelRoomServiceManagementSystem extends Thread{
    private String serviceType;
    HotelRoomServiceManagementSystem(String serviceType){
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
