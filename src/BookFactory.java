public class BookFactory {
    public static Book createBook(String title, String author, String ISBN, int publicationYear) {
        return new Book(title, author, ISBN, publicationYear);
    }
}
