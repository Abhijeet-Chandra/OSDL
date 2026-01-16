package LabExercises.Q1;

public class Main {
    public static void main(String [] args) throws InterruptedException {
        System.out.println("Method 1: By extending Thread class: ");
        HotelRoomServiceManagementSystem thread1 = new HotelRoomServiceManagementSystem("Room cleaning");
        HotelRoomServiceManagementSystem thread2 = new HotelRoomServiceManagementSystem("Food Delivery");
        HotelRoomServiceManagementSystem thread3 = new HotelRoomServiceManagementSystem("Maintenance");
        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();

        System.out.println("Method 2: By implementing Runnable interface: ");
        HotelRoomServiceManagementSystem2 task1 = new HotelRoomServiceManagementSystem2("Room Cleaning");
        HotelRoomServiceManagementSystem2 task2 = new HotelRoomServiceManagementSystem2("Food Delivery");
        HotelRoomServiceManagementSystem2 task3 = new HotelRoomServiceManagementSystem2("Maintenance");
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}
