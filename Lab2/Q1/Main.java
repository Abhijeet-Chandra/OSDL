package Q1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HotelBillingSystem hotelBillingSystem = new HotelBillingSystem();
        double roomTariff;
        int stayDuration;
        double serviceCharges;

        System.out.println("Enter room tariff: ");
        roomTariff = sc.nextDouble();
        System.out.println("Enter stay duration: ");
        stayDuration = sc.nextInt();
        System.out.println("Enter service charge: ");
        serviceCharges = sc.nextDouble();
        //autoboxing:
        System.out.println("Autoboxing: ");
        hotelBillingSystem.setRoomTariff(roomTariff);
        hotelBillingSystem.setStayDuration(stayDuration);
        hotelBillingSystem.setServiceCharges(serviceCharges);
        //here double is boxed as Double, int as Integer
        System.out.println("Autoboxed!");
        System.out.println("----------------------------------------------");

        double unboxedRoomTariff = hotelBillingSystem.getRoomTariff();
        int unboxedStayDuration = hotelBillingSystem.getStayDuration();
        double unboxedServiceCharges = hotelBillingSystem.getServiceCharges();
        System.out.println("After Auto unboxing: ");
        System.out.println("Tariff: "+unboxedRoomTariff);
        System.out.println("Stay duration: "+unboxedStayDuration);
        System.out.println("Service Charge: "+unboxedServiceCharges);
        System.out.println("Total Charge: "+((unboxedRoomTariff*unboxedStayDuration)+unboxedServiceCharges));
    }
}
