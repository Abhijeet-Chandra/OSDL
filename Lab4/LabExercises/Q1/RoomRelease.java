package LabExercise.Q1;
public class RoomRelease extends Thread{
    HotelCapacity capacity;
    public RoomRelease(HotelCapacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            capacity.roomRelease(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
