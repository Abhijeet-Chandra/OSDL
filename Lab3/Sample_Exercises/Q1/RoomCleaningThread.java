package Sample_exercises.q1;

public class RoomCleaningThread extends Thread{
    private String roomName;

    RoomCleaningThread(String roomName){
        this.roomName = roomName;
    }

    @Override
    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println(roomName+"-Cleaning step"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
