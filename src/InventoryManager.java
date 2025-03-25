import java.util.HashMap;
import java.util.Map;

public class InventoryManager implements Inventory, InventoryGetAll{
    private static InventoryManager instance;

    private Map<String, Map<String, Book>> inv;

    private InventoryManager() {
        inv = new HashMap<>();
        inv.put("available", new HashMap<>());
        inv.put("notAvailable", new HashMap<>());
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    @Override
    public void addBook(Book book) {
        inv.get("available").put(book.getIsbn(), book);
        System.out.println("Book added: " + book);
    }

    @Override
    public void removeBook(Book book) {
        for (String category : inv.keySet()) {
            if (inv.get(category).remove(book.getIsbn()) != null) {
                System.out.println("Book removed from " + category + ": " + book);
                return;
            }
        }
        System.out.println("Book not found: " + book);
    }

    @Override
    public Map<String, Map<String, Book>> getInv() {
        return inv;
    }

}




