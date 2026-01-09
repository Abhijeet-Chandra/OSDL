package Q2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomType;
        int noOfDays;

        System.out.println("Enter room type: ");
        roomType = sc.nextLine();
        System.out.println("Enter no of days: ");
        noOfDays = sc.nextInt();

        RoomType room = null;
        if(roomType.equalsIgnoreCase("standard")){
            room = RoomType.STANDARD;
        }
        else if(roomType.equalsIgnoreCase("deluxe")){
            room = RoomType.DELUXE;
        }
        else if(roomType.equalsIgnoreCase("suite")){
            room = RoomType.SUITE;
        }
        else {
            System.out.println("Enter a valid room type!");
            return;
        }
        System.out.println("Room type: "+roomType);
        System.out.println("Base price: "+room.getBaseTariff());
        System.out.println("Number of days: "+noOfDays);
        System.out.println("Total cost: "+room.calculateTotalCost(noOfDays));

    }
}
