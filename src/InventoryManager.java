// SINGLETON PATTERN

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory instance;  // Static instance variable

    private Map<String, Map<String, Book>> inv;

    // Private constructor to prevent direct instantiation
    private Inventory() {
        inv = new HashMap<>();
        inv.put("available", new HashMap<>());
        inv.put("notAvailable", new HashMap<>());
    }

    // Public method to provide a global access point
    public static Inventory getInstance() {
        if (instance == null) {  // Lazy initialization
            instance = new Inventory();
        }
        return instance;
    }

    // Add a book to inventory
    public void addBook(Book book) {
        inv.get("available").put(book.getIsbn(), book);
        System.out.println("Book added: " + book);
    }

    // Remove a book from inventory
    public void removeBook(Book book) {
        for (String category : inv.keySet()) {
            if (inv.get(category).remove(book.getIsbn()) != null) {
                System.out.println("Book removed from " + category + ": " + book);
                return;
            }
        }
        System.out.println("Book not found: " + book);
    }

    public Map<String, Map<String, Book>> getInv() {
        return inv;
    }

//    public void setInv(Map<String, Map<String, Book>> inv) {
//        this.inv = inv;
//    }
}



//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.HashMap;
//
//public class Inventory {
//
//    Map<String, Map<String, Book>> inv;
//
//    public Inventory() {
//        inv = new HashMap<>();
//        inv.put("available", new HashMap<>());
//        inv.put("notAvailable", new HashMap<>());
//    }
//
//    public static Inventory getInstance() {
//        if (instance == null) {
//            instance = new Inventory();
//        }
//        return instance;
//    }
//
//    // Add a book to a category (available or notAvailable)
//    public void addBook(Book book) {
////        if (!inv.containsKey(category)) {
////            System.out.println("Invalid category: " + category);
////            return;
////        }
//        inv.get("available").put(book.getIsbn(), book);
//        System.out.println("Book added "+ book);
//    }
//
//    // Remove a book by title from a category
//    public void removeBook(Book book) {
////        if (!inv.containsKey(category)) {
////            System.out.println("Invalid category: " + category);
////            return;
////        }
//        for (String category : inv.keySet()) {
//            if (inv.get(category).remove(book.getIsbn()) != null) {
//                System.out.println("Book removed from " + category + ": " + book);
//            } else {
//                System.out.println("Book not found in " + category + ": " + book);
//            }
//        }
//    }
//
//    // Search for a book by title in a category
////    public Book searchBook(String category, String title) {
////        if (!inv.containsKey(category)) {
////            System.out.println("Invalid category: " + category);
////            return null;
////        }
////        return inv.get(category).get(title);
////    }
////
////    public Book deepSearchBook(String query) {
////        for (String category : inv.keySet()) {
////            for (Book book : inv.get(category).values()) {
////                if (book.getTitle().equalsIgnoreCase(query) ||
////                        book.getAuthor().equalsIgnoreCase(query) ||
////                        book.getIsbn().equals(query)) {
////                    System.out.println("Book found in category: " + category);
////                    return book;
////                }
////            }
////        }
////        System.out.println("Book not found: " + query);
////        return null;
////    }
//
//
//
//
//    // Return a book (Move from 'notAvailable' to 'available')
////    public void returnBook(String title) {
////        if (inv.get("notAvailable").containsKey(title)) {
////            Book book = inv.get("notAvailable").remove(title);
////            inv.get("available").put(title, book);
////            System.out.println("Book returned: " + book);
////        } else {
////            System.out.println("Book not found in issued books: " + title);
////        }
////    }
//}
