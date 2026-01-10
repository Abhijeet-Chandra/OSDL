public class StandardRoom extends Room implements Amenities {
    public StandardRoom(int roomNo, double basePrice) {
        super(roomNo, basePrice);
    }
    @Override
    public double calculateTariff() {
        return getBasePrice()+500;
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast provided for standard Room!");
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi Not provided for standard room.");
    }
}
