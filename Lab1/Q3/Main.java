import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int roomNo;
        double baseTariff;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number: ");
        roomNo = sc.nextInt();
        System.out.println("Enter base tariff: ");
        baseTariff = sc.nextDouble();

        Room r;

        //standard room:

        r = new StandardRoom(roomNo,baseTariff);
        System.out.println("Final price of standard room: "+r.calculateTariff());
        
        //luxury room:

        r = new LuxuryRoom(roomNo, baseTariff);
        System.out.println("Final price of luxury room: "+r.calculateTariff());
        sc.close();
    }
}
