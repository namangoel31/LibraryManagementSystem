import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookSearch {
    static List<Book> searchBooks(InventoryManager inventory, String query) {
        Map<String, Map<String, Book>> inv = inventory.getInv();
        List<Book> result = new ArrayList<>();
        for (String category : inv.keySet()) {
            for (Book book : inv.get(category).values()) {
                if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    static Book searchBookByISBN(InventoryManager inventory, String isbn) {
        Map<String, Map<String, Book>> inv = inventory.getInv();
        for (String category : inv.keySet()) {
            if (inv.get(category).containsKey(isbn)) {
                return inv.get(category).get(isbn);
            }
        }
        return null;
    }
}
