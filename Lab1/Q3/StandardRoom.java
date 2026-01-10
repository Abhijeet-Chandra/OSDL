public class StandardRoom extends Room{
    public StandardRoom(int roomNo, double baseTariff) {
        super(roomNo,baseTariff);
    }

    @Override
    public double calculateTariff(){
        return getBaseTariff()+500;
    }
}
