import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.classfile.constantpool.MemberRefEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Book implements Serializable{
    private String bookId;
    private String bookTitle;
    private String authorName;
    private String genre;
    boolean available;

    public Book(String bookId, String bookTitle, String authorName, String genre) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.genre = genre;
        this.available = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book Id: " + bookId + ", Book Title " + bookTitle + ", Author Name: " + authorName + ", Genre: " + genre
                + " Is available?: " + available;
    }
}

class Member implements Serializable{
    private String memberId;
    private String memberName;
    private String contactNumber;

    public Member(String memberId, String memberName, String contactNumber) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.contactNumber = contactNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Member Id: " + memberId + ", Member Name: " + memberName + ", Contact Number: " + contactNumber;
    }
}

public class LibraryManagementSystem extends Application {

    HashMap<String, Book> bookMap = new HashMap<>();
    HashMap<String, Member> memberMap = new HashMap<>();

    class GenericManager<T extends String> implements Serializable{
        HashMap<T, ArrayList<T>> crossMap = new HashMap<>();

        public void issue(T memberId, T bookId) throws Exception {
            if (!bookMap.get(bookId).isAvailable()) {
                throw new Exception("Book is out of stock");
            }
            if (!crossMap.containsKey(memberId)) {
                crossMap.put(memberId, new ArrayList<>());
            }

            bookMap.get(bookId).setAvailable(false);
            crossMap.get(memberId).add(bookId);
        }

        public void returnBook(T memberId, T bookID) throws Exception {
            if (bookMap.get(bookID).isAvailable()) {
                throw new Exception("Book already returned!!");
            }
            if (!crossMap.containsKey(memberId)) {
                throw new Exception("No such Member!!");
            }
            String toRemove = null;
            for (String bookIds : crossMap.get(memberId)) {
                if (bookID.equals(bookIds)) {
                    toRemove = bookIds;
                }
            }

            if (toRemove == null) {
                throw new Exception("No such Book is issued!");
            } else {
                bookMap.get(toRemove).setAvailable(true);
                crossMap.get(memberId).remove(toRemove);
            }
        }

        public HashMap<T, ArrayList<T>> getAll() {
            return crossMap;
        }
    }

    GenericManager<String> manager = new GenericManager<>();

    // input fields:
    // books:
    TextField bidField = new TextField();
    TextField btitleField = new TextField();
    TextField bAuthorField = new TextField();
    TextField bGenreField = new TextField();

    // members:
    TextField midField = new TextField();
    TextField mNameField = new TextField();
    TextField contactField = new TextField();

    // Buttons:
    Button addBookBtn = new Button("Add book");
    Button viewBookBtn = new Button("View All books");
    Button viewAvailBookBtn = new Button("View All available books");
    Button addMemberBtn = new Button("Add Member");
    Button viewAllMembersBtn = new Button("View All Members");
    Button issueBookBtn = new Button("Issue Book");
    Button returnBookBtn = new Button("Return Book");
    Button showAllIssuesBtn = new Button("Show All Issues");
    Button saveDataBtn = new Button("Save Data");
    Button loadDataBtn = new Button("Load Data");

    @Override
    public void start(Stage stage) throws Exception {

        // BASIC LAYOUT:

        GridPane bookgrid = new GridPane();
        bookgrid.setHgap(10);
        bookgrid.setVgap(10);
        Label labelBook = new Label("=====================Book Details=====================");
        bookgrid.add(new Label("Book Id: "), 0, 0);
        bookgrid.add(bidField, 1, 0);

        bookgrid.add(new Label("Book title: "), 0, 1);
        bookgrid.add(btitleField, 1, 1);

        bookgrid.add(new Label("Book Author: "), 0, 2);
        bookgrid.add(bAuthorField, 1, 2);

        bookgrid.add(new Label("Book Genre: "), 0, 3);
        bookgrid.add(bGenreField, 1, 3);

        GridPane membergrid = new GridPane();
        membergrid.setHgap(10);
        membergrid.setVgap(10);
        Label labelMember = new Label("=====================Member Details=====================");
        membergrid.add(new Label("Member Id: "), 0, 0);
        membergrid.add(midField, 1, 0);

        membergrid.add(new Label("Member name: "), 0, 1);
        membergrid.add(mNameField, 1, 1);

        membergrid.add(new Label("Member Contact: "), 0, 2);
        membergrid.add(contactField, 1, 2);

        VBox buttons = new VBox(10, addBookBtn, viewBookBtn, viewAvailBookBtn, addMemberBtn, viewAllMembersBtn,
                issueBookBtn, returnBookBtn, showAllIssuesBtn, saveDataBtn, loadDataBtn);

        TextArea output = new TextArea();
        output.setEditable(false);

        VBox root = new VBox(15, labelBook, bookgrid, labelMember, membergrid, buttons, output);
        root.setPadding(new javafx.geometry.Insets(10));
        ScrollPane scroll = new ScrollPane(root);

        // LOGIC:
        addBookBtn.setOnAction(e -> {
            try {
                String bookId = bidField.getText();
                String bookTitle = btitleField.getText();
                String authorName = bAuthorField.getText();
                String genre = bGenreField.getText();

                if (bookId.isEmpty() || bookTitle.isEmpty() || authorName.isEmpty() || genre.isEmpty()) {
                    throw new Exception("One or more field(s) is empty.");
                }

                if (bookMap.containsKey(bookId)) {
                    throw new Exception("Book is already there");
                }

                bookMap.put(bookId, new Book(bookId, bookTitle, authorName, genre));
                output.setText("Book Added");
            } catch (Exception ex) {
                showAlert(ex.getMessage());
            }
            allClear();
        });

        viewBookBtn.setOnAction(e -> {
            boolean isFound = false;

            StringBuilder sb = new StringBuilder();
            for (Book b : bookMap.values()) {
                sb.append(b).append("\n");
                isFound = true;
            }
            if (!isFound) {
                output.setText("No data Found!");
            } else {
                output.setText(sb.toString());
            }
        });

        viewAvailBookBtn.setOnAction(e -> {
            boolean isFound = false;

            StringBuilder sb = new StringBuilder();
            for (Book b : bookMap.values()) {
                if (b.isAvailable()) {
                    sb.append(b).append("\n");
                    isFound = true;
                }
            }
            if (!isFound) {
                output.setText("No data Found!");
            } else {
                output.setText(sb.toString());
            }
        });

        addMemberBtn.setOnAction(e -> {
            try {
                String memberId = midField.getText();
                String memberName = mNameField.getText();
                String contactNumber = contactField.getText();

                if (memberId.isEmpty() || memberName.isEmpty() || contactNumber.isEmpty()) {
                    throw new Exception("One or more field(s) is empty.");
                }

                if (memberMap.containsKey(memberId)) {
                    throw new Exception("Member is already Added");
                }

                memberMap.put(memberId, new Member(memberId, memberName, contactNumber));
                output.setText("Member Added");
            } catch (Exception ex) {
                showAlert(ex.getMessage());
            }
            allClear();
        });

        viewAllMembersBtn.setOnAction(e -> {
            boolean isFound = false;

            StringBuilder sb = new StringBuilder();
            for (Member m : memberMap.values()) {
                sb.append(m).append("\n");
                isFound = true;
            }
            if (!isFound) {
                output.setText("No data Found!");
            } else {
                output.setText(sb.toString());
            }
        });

        issueBookBtn.setOnAction(e -> {
            try {
                String memberId = midField.getText();
                String bookId = bidField.getText();

                if (!bookMap.containsKey(bookId)) {
                    throw new Exception("Book Not found");
                }

                if (!memberMap.containsKey(memberId)) {
                    throw new Exception("Member not found!!");
                }

                manager.issue(memberId, bookId);

                output.setText("Book Issued!!");
            } catch (Exception ex) {
                showAlert(ex.getMessage());
            }
        });

        returnBookBtn.setOnAction(e -> {
            try {
                String memberId = midField.getText();
                String bookId = bidField.getText();

                if (!bookMap.containsKey(bookId)) {
                    throw new Exception("Book Not found");
                }

                if (!memberMap.containsKey(memberId)) {
                    throw new Exception("Member not found!!");
                }

                manager.returnBook(memberId, bookId);

                output.setText("Book returned");
            } catch (Exception ex) {
                showAlert(ex.getMessage());
            }
        });

        showAllIssuesBtn.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            if (manager.getAll().isEmpty()) {
                output.setText("No Issues Yet!");
                return;
            } else {
                for (Map.Entry<String, ArrayList<String>> entry : manager.getAll().entrySet()) {
                    sb.append("Member Id: ").append(entry.getKey()).append("|").append(entry.getValue()).append("\n");
                }
            }
            output.setText(sb.toString());
        });

        saveDataBtn.setOnAction(e->{
            try{
                FileOutputStream fos = new FileOutputStream("data.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bookMap);
                oos.writeObject(memberMap);
                oos.writeObject(manager);

                fos.close();
                oos.close();
                output.setText("Data Saved Successfully!");
            }
            catch(Exception ex){
                showAlert(ex.getMessage());
            }
        });

        loadDataBtn.setOnAction(e->{
            try{
                FileInputStream fis = new FileInputStream("data.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                bookMap = (HashMap<String,Book>)ois.readObject();
                memberMap = (HashMap<String,Member>)ois.readObject();
                manager = (GenericManager<String>)ois.readObject();

                ois.close();
                output.setText("Data Loaded successfully!!");
            }
            catch(Exception ex){
                showAlert(ex.getMessage());
            }
        });

        stage.setScene(new Scene(scroll, 500, 500));
        stage.show();
    }

    public void allClear() {
        bidField.clear();
        btitleField.clear();
        bAuthorField.clear();
        bGenreField.clear();
        midField.clear();
        mNameField.clear();
        contactField.clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
