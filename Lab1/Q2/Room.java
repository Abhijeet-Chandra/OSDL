public class Room {
    private int roomNo;
    private String roomType;
    private double basePrice;

    public Room(int roomNo, String roomType, double basePrice) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.basePrice = basePrice;
    }

    public Room(int roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    
}
