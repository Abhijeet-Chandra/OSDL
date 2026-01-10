public class DeluxeRoom extends Room{

    private boolean wifiAvalability;
    private boolean complimentaryBreakfastAvailability;
    public DeluxeRoom(int roomNo, String roomType, double basePrice,boolean wifiAvalability,boolean complimentaryBreakfastAvailability) {
        super(roomNo, roomType, basePrice);
        this.complimentaryBreakfastAvailability = complimentaryBreakfastAvailability;
        this.wifiAvalability = wifiAvalability;
    }

    public DeluxeRoom(int roomNo, String roomType,boolean wifiAvalability,boolean complimentaryBreakfastAvailability) {
        super(roomNo, roomType);
        this.complimentaryBreakfastAvailability = complimentaryBreakfastAvailability;
        this.wifiAvalability = wifiAvalability;
    }

    public boolean isWifiAvailable() {
        return wifiAvalability;
    }

    public boolean isComplimentaryBreakfastAvailable() {
        return complimentaryBreakfastAvailability;
    }

}
