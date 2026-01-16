package Sample_exercises.q1;

import Sample_exercises.q1.RoomCleaningThread;

public class Main{
    public static void main(String[] args){
        RoomCleaningThread thread1 = new RoomCleaningThread("Room1");
        RoomCleaningThread thread2 = new RoomCleaningThread("Room2");
        thread1.start();
        thread2.start();
    }
}
