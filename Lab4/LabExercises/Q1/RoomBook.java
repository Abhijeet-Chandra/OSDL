package LabExercise.Q1;

import java.util.Scanner;

public class RoomBook extends Thread{
    Scanner sc;
    HotelCapacity capacity;
    public RoomBook(HotelCapacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            capacity.roomBook(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

