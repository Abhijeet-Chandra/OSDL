public class Hotel {
    int availableRooms;
    int totalRooms;
    public Hotel(int totalRooms) {
        this.availableRooms = totalRooms;
        this.totalRooms = totalRooms;
    }
    
    synchronized void bookRoom(){
        while(availableRooms==0){
            System.out.println(Thread.currentThread().getName()+" is waiting!!");
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted while booking room!!");
            }
        }
        availableRooms--;
        System.out.println(Thread.currentThread().getName()+" booked a room!!");
    }

    synchronized void releaseRoom(){
        while(availableRooms==totalRooms){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted while releasing room!!");
            }
        }
        availableRooms++;
        System.out.println(Thread.currentThread().getName()+" released a room!!");
        notifyAll();
    }
}
