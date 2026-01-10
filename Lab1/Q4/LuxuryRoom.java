public class LuxuryRoom extends Room implements Amenities {
    public LuxuryRoom(int roomNo, double basePrice) {
        super(roomNo, basePrice);
    }
    @Override
    public double calculateTariff() {
        return getBasePrice()+5000;
    }
    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast provided for LuxuryRoom Room!");
    }

    @Override
    public void provideWifi() {
        System.out.println("Wifi  provided for LuxuryRoom Room!");
    }
}
