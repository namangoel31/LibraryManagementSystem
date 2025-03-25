import java.util.List;
import java.util.Map;

public class Library {
    String branch;

    private InventoryManager inventory;

    public Library(String branch, InventoryManager inventory) {
        this.branch = branch;
        this.inventory = inventory;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setInventory(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public List<Book> searchBooks(String titleOrAuthor) {
        System.out.println("------ Found following matches for: " + titleOrAuthor +" -------");
        return BookSearch.searchBooks(this.inventory, titleOrAuthor);
    }

    public Book searchBookByISBN(String isbn) {
        return BookSearch.searchBookByISBN(this.inventory, isbn);
    }

    public void showAllBooks() {
        Map<String, Map<String, Book>> inv = this.inventory.getInv();
        System.out.println("--------- Start of Inventory ----------");
        for (String category : inv.keySet()) {
            System.out.println("Category: " + category);
            for (Book book : inv.get(category).values()) {
                System.out.println("  " + book);
            }
        }
        System.out.println("--------- End of Inventory ---------");
    }

}
