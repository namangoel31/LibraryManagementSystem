public class Main {

    public static void main(String[] args) {
        Book book1 = BookFactory.createBook("Book 1", "Author 1", "ISBN 1", 2001);
        Book book2 = BookFactory.createBook("Book 2", "Author 2", "ISBN 2", 2002);
        Book book3 = BookFactory.createBook("Book 2", "Author 3", "ISBN 3", 2003);
        Book book4 = BookFactory.createBook("Book 4", "Author 3", "ISBN 4", 2004);
        Book book5 = BookFactory.createBook("Book 1", "Author 1", "ISBN 5", 2005);

        InventoryManager inv = InventoryManager.getInstance();
        inv.addBook(book1);
        inv.addBook(book2);
        inv.addBook(book3);
        inv.addBook(book4);
        inv.addBook(book5);

        PatronManager patronManager = PatronManager.getInstance();
        Patron patron1 = new Patron("P001", "Alice Johnson", "alice@example.com");
        patronManager.addPatron(patron1);

        Patron patron2 = new Patron("P002", "John Kelly", "Kelly@johnsnow.com");
        patronManager.addPatron(patron2);

        Library library = new Library("AirTribe", inv);

        TransactionBooth transactionBooth = new TransactionBooth(inv);

//        transactionBooth.issueBook(book1);

        library.showAllBooks();

        transactionBooth.issueBookToPatron(book1, "P001");
        transactionBooth.issueBookToPatron(book1, "P002");
        // Checking Alice's borrowing history
        patronManager.showCurrentlyBorrowed("P001");

        // Returning the book
        transactionBooth.returnBookFromPatron(book1, "P001");

        // Checking Alice's borrowing history again
        patronManager.showCurrentlyBorrowed("P001");

        System.out.println(library.searchBooks("Book 1"));

        patronManager.showBorrowingHistory("P001");

        library.showAllBooks();
        patronManager.showAllPatrons();

    }
}
