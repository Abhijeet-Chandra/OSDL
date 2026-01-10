public class LuxuryRoom extends Room{
    public LuxuryRoom(int roomNo, double baseTariff) {
        super(roomNo, baseTariff);
    }
    @Override
    public double calculateTariff(){
        return getBaseTariff()+2000;
    }
}
