package LabExercise.Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelCapacity capacity = new HotelCapacity();
        RoomBook roomBookThread = new RoomBook(capacity);
        RoomRelease roomReleaseThread = new RoomRelease(capacity);

        roomBookThread.start();
        roomReleaseThread.start();
    }
}
