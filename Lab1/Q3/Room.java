public class Room {
    private int roomNo;
    private double baseTariff;

    public Room(int roomNo, double baseTariff) {
        this.roomNo = roomNo;
        this.baseTariff = baseTariff;
    }

    public double calculateTariff(){
        return baseTariff;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public double getBaseTariff() {
        return baseTariff;
    }

    
}
