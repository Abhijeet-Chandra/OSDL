public class Customer extends Thread {
    private Hotel hotel;

    public Customer(Hotel hotel, String customerName){
        super(customerName);
        this.hotel = hotel;
    }

    @Override
    public void run(){
        hotel.bookRoom();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        hotel.releaseRoom();
    }
}
