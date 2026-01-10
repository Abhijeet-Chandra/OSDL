import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roomNo;
        String roomType;
        double basePrice;
        boolean wifiAvalability;
        boolean complimentaryBreakfastAvailability;


        System.out.println("Enter room number: ");
        roomNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter room type: ");
        roomType = sc.nextLine();
        System.out.println("Enter base price: ");
        basePrice = sc.nextDouble();
        
        if(roomType.equalsIgnoreCase("normal")){
            Room r = new Room(roomNo, roomType,basePrice);
            System.out.println("Room No: "+r.getRoomNo());
            System.out.println("Room Type: "+r.getRoomType());
            System.out.println("Room base price: "+r.getBasePrice());
        }
        else if(roomType.equalsIgnoreCase("deluxe")){
            System.out.println("Is wifi Available?: ");
            wifiAvalability = sc.nextBoolean();
            System.out.println("Is complimentary breakfast available?: ");

            complimentaryBreakfastAvailability = sc.nextBoolean();
            DeluxeRoom deluxeRoom = new DeluxeRoom(roomNo, roomType,basePrice, wifiAvalability, complimentaryBreakfastAvailability);
            System.out.println("Room No: "+deluxeRoom.getRoomNo());
            System.out.println("Room Type: "+deluxeRoom.getRoomType());
            System.out.println("Room base price: "+deluxeRoom.getBasePrice());
            System.out.println("Wifi available?: "+deluxeRoom.isWifiAvailable());
            System.out.println("complimentary breakfast available?: "+deluxeRoom.isComplimentaryBreakfastAvailable());
        }
        else System.out.println("Enter a valid room type!");

    }
}
