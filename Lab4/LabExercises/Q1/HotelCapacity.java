package LabExercise.Q1;

public class HotelCapacity {
    int currRoom;
    boolean [] rooms = new boolean[5]; //assume there are 5 rooms in hotel
    synchronized void roomBook(int roomNo){
        while(rooms[roomNo]){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while booking room lol!");
            }
        }
        currRoom = roomNo;
        rooms[roomNo] = true;
        System.out.println("Room no: "+currRoom+" booked!!!!");
        notify();
    }
    synchronized void roomRelease(int roomNo){
        while(!rooms[roomNo]){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while leaving room lol!");
            }
        }
        currRoom = roomNo;
        rooms[roomNo] = false;
        System.out.println("Room no: "+roomNo+" emptied!!!!");
        notify();
    }
}
