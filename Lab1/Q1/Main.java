import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long bookId;
        String bookTitle;
        String authorName;
        boolean availability;
        System.out.println("Enter book id: ");
        bookId = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter book title: ");
        bookTitle = sc.nextLine();
        System.out.println("Enter author name: ");
        authorName = sc.nextLine();
        System.out.println("Is book available? : ");
        availability = sc.nextBoolean();
        
        Book book = new Book();

        //using setters
        book.setBookId(bookId);
        book.setBookTitle(bookTitle);
        book.setAuthorName(authorName);
        book.setAvailability(availability);

        System.out.println();
        //using getters
        System.out.println("Book id: "+book.getBookId());
        sc.nextLine();
        System.out.println("Book title: "+book.getBookTitle());
        System.out.println("Author name: "+book.getAuthorName());
        System.out.println("Book availablility? : "+book.isAvailable());
        sc.close();
    }
}
