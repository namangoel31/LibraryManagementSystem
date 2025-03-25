public interface PatronInterface {
    void addPatron(Patron patron);
    void removePatron(Patron patron);
    void assignBookToPatron(Book book, String patronId);
    void removeBookFromPatron(Book book, String patronId);
}
