public abstract class Room {
    private int roomNo;
    private double basePrice;
    
    public abstract double calculateTariff();

    public Room(int roomNo, double basePrice) {
        this.roomNo = roomNo;
        this.basePrice = basePrice;
    }

    public void displayRoomDetails(){
        System.out.println("Room No: "+roomNo);
        System.out.println("Base Price: "+basePrice);
    }

    public int getRoomNo() {
        return roomNo;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
