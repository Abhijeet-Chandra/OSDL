import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int roomNo;
        double basePrice;
        String roomType;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter room number: ");
        roomNo = sc.nextInt();
        System.out.println("Enter base price: ");
        basePrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter room type(standard/luxury): ");
        roomType = sc.nextLine();

        System.out.println();
        Room r;
        if(roomType.equalsIgnoreCase("standard")){
            r = new StandardRoom(roomNo, basePrice);
            r.displayRoomDetails();
            System.out.println("Final tariff: "+r.calculateTariff());
            ((StandardRoom) r).provideBreakfast();
            ((StandardRoom) r).provideWifi();
        }
        else if(roomType.equalsIgnoreCase("luxury")){
            r = new LuxuryRoom(roomNo, basePrice);
            r.displayRoomDetails();
            System.out.println("Final tariff: "+r.calculateTariff());
            ((LuxuryRoom) r).provideBreakfast();
            ((LuxuryRoom) r).provideWifi();
        }
        else System.out.println("Enter a valid roomType");
    }
}
