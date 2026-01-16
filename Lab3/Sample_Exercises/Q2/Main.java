package Sample_exercises.q2;

public class Main {
    public static void main(String[] args) {
        RoomCleaningTask task1 = new RoomCleaningTask("Room 1");
        RoomCleaningTask task2 = new RoomCleaningTask("Room 2");

        Thread t1 = new Thread(task1,"cuteeeeee");
        Thread t2 = new Thread(task2);
        System.out.println(t1.getName());
        System.out.println(t1.threadId());
        t1.start();
        t2.start();

    }
}
