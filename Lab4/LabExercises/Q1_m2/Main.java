import java.util.*;
public class Main {
    public static void main(String[] args) {
        int totalRooms;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of rooms: ");
        totalRooms = sc.nextInt();
        Hotel hotel = new  Hotel(totalRooms);
        Customer c1 = new Customer(hotel, "c1");
        Customer c2 = new Customer(hotel, "c2");
        Customer c3 = new Customer(hotel, "c3");
        Customer c4 = new Customer(hotel, "c4");
        Customer c5 = new Customer(hotel, "c5");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
