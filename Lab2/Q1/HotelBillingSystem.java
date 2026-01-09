package Q1;

public class HotelBillingSystem {
    private Double roomTariff;
    private Integer stayDuration;
    private Double serviceCharges;

    public Double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(Double serviceCharges) throws Exception {
        if(serviceCharges<0)throw new Exception("Enter a positive value");
        else this.serviceCharges = serviceCharges;
    }

    public Integer getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(Integer stayDuration) throws Exception{
        if(stayDuration<0)throw new Exception("Enter a positive value");
        this.stayDuration = stayDuration;
    }

    public Double getRoomTariff() {
        return roomTariff;
    }

    public void setRoomTariff(Double roomTariff) throws Exception{
        if(roomTariff<0)throw new Exception("Enter a positive value");
        this.roomTariff = roomTariff;
    }
}
