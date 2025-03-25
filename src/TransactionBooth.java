import java.util.Map;

public class TransactionBooth implements BookIssueReturn{

    private final InventorySearch inventorySearch;
    private final PatronInterface patronManager;

    public TransactionBooth(InventorySearch inventory) {
        this.inventorySearch = inventory;
        this.patronManager = PatronManager.getInstance();
    }
    @Override
    public boolean issueBook(Book book) {
        Map<String, Map<String, Book>> inv= inventorySearch.getInv();
        if (inv.get("available").containsKey(book.getIsbn())) {
            inv.get("available").remove(book.getIsbn());
            inv.get("notAvailable").put(book.getIsbn(), book);
            book.setAvailable(false);
            System.out.println("Book issued: " + book);
            return true;
        } else {
            System.out.println("Book is not available for issuing: " + book);
            return false;
        }
    }

    @Override
    public boolean returnBook(Book book) {
        Map<String, Map<String, Book>> inv= inventorySearch.getInv();
        if (inv.get("notAvailable").containsKey(book.getIsbn())) {
            inv.get("notAvailable").remove(book.getIsbn());
            inv.get("available").put(book.getIsbn(), book);
            book.setAvailable(true);
            System.out.println("Book returned: " + book);
            return true;
        } else {
            System.out.println("Book is not found in issued books: " + book);
            return false;
        }
    }

    public void issueBookToPatron(Book book, String patronId) {
        boolean success = issueBook(book);
        if (success){
            patronManager.assignBookToPatron(book, patronId);
        }
    }

    public void returnBookFromPatron(Book book, String patronId) {
        boolean success = returnBook(book);
        if (success){
            patronManager.removeBookFromPatron(book, patronId);
        }
    }

}
