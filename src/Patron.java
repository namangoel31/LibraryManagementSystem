import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;
    private List<Book> historyOfBooks;

    public Patron(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
        this.historyOfBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    //Will be required for recommendations
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
        historyOfBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowingHistory() {
        System.out.println("Borrowing History for: " + name);
        for (Book book : historyOfBooks) {
            System.out.println("  - " + book);
        }
    }

    public void displayCurrentlyBorrowed() {
        System.out.println("Currently borrowed by: " + name);
        for (Book book : borrowedBooks) {
            System.out.println("  - " + book);
        }
    }

    @Override
    public String toString() {
        return "Patron{ID='" + id + "', Name='" + name + "', Contact='" + contactInfo + "'}";
    }
}
