package Q2;

public enum RoomType {
    STANDARD(1000),
    DELUXE(5000),
    SUITE(10000);

    private int baseTariff;
    RoomType(int baseTariff) {
        this.baseTariff = baseTariff;
    }

    public int getBaseTariff() {
        return baseTariff;
    }

    public int calculateTotalCost(int noOfDays){
        return baseTariff*noOfDays;
    }
}
