import java.util.HashMap;
import java.util.Map;

public class PatronManager implements PatronInterface{
    private static PatronManager instance;
    private Map<String, Patron> patrons;

    private PatronManager() {
        patrons = new HashMap<>();
    }

    public static PatronManager getInstance() {
        if (instance == null) {
            instance = new PatronManager();
        }
        return instance;
    }

    @Override
    public void addPatron(Patron patron) {
        if (!patrons.containsKey(patron.getId())) {
            patrons.put(patron.getId(), patron);
            System.out.println("New patron added: " + patron);
        } else {
            System.out.println("Patron ID already exists: " + patron.getId());
        }
    }

    @Override
    public void removePatron(Patron patron){
        if (patrons.containsKey(patron.getId())) {
            patrons.remove(patron.getId(), patron);
            System.out.println("Patron removed: " + patron);
        } else {
            System.out.println("Patron does not exists in database");
        }
    }

    public void updatePatronInfo(String id, String newName, String newContact) {
        Patron patron = patrons.get(id);
        if (patron != null) {
            patron.setName(newName);
            patron.setContactInfo(newContact);
            System.out.println("Updated Patron: " + patron);
        } else {
            System.out.println("Patron not found: " + id);
        }
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public void showBorrowingHistory(String id) {
        Patron patron = patrons.get(id);
        if (patron != null) {
            patron.displayBorrowingHistory();
        } else {
            System.out.println("Patron not found: " + id);
        }
    }

    public void showCurrentlyBorrowed(String id) {
        Patron patron = patrons.get(id);
        if (patron != null) {
            patron.displayCurrentlyBorrowed();
        } else {
            System.out.println("Patron not found: " + id);
        }
    }

    public void showAllPatrons() {
        Map<String, Patron> patrons = this.patrons;
        System.out.println("Patron List:");
        for (String patronName : patrons.keySet()) {
            System.out.println("PatronName: " + patronName);
            System.out.println("  " + patrons.get(patronName));
        }
    }

    @Override
    public void assignBookToPatron(Book book, String patronId) {
        Patron patron = patrons.get(patronId);
        if (patron == null) {
            System.out.println("Patron not found!");
            return;
        }
        patron.addBorrowedBook(book);
    }

    @Override
    public void removeBookFromPatron(Book book, String patronId) {
        Patron patron = patrons.get(patronId);
        if (patron == null) {
            System.out.println("Patron not found!");
            return;
        }
        patron.returnBook(book);
    }

}
