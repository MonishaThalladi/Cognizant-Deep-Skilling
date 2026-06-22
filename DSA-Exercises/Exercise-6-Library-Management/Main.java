import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 6: Library Management System ===\n");

        // Create sample books
        Book[] books = {
            new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(102, "1984", "George Orwell"),
            new Book(103, "To Kill a Mockingbird", "Harper Lee"),
            new Book(104, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(105, "Pride and Prejudice", "Jane Austen"),
            new Book(106, "The Hobbit", "J.R.R. Tolkien"),
            new Book(107, "Fahrenheit 451", "Ray Bradbury")
        };

        // Display all books
        System.out.println("--- All Books in Library ---");
        for (Book b : books) {
            System.out.println(b);
        }

        // ===== LINEAR SEARCH =====
        System.out.println("\n=== Linear Search (O(n)) ===");
        String searchTitle1 = "1984";
        Book found1 = LibrarySearch.linearSearch(books, searchTitle1);
        if (found1 != null) {
            System.out.println("Result: " + found1);
        } else {
            System.out.println("Book not found!");
        }

        String searchTitle2 = "The Hobbit";
        Book found2 = LibrarySearch.linearSearch(books, searchTitle2);
        if (found2 != null) {
            System.out.println("Result: " + found2);
        } else {
            System.out.println("Book not found!");
        }

        String searchTitle3 = "Unknown Book";
        Book found3 = LibrarySearch.linearSearch(books, searchTitle3);
        if (found3 != null) {
            System.out.println("Result: " + found3);
        } else {
            System.out.println("Book not found!");
        }

        // ===== BINARY SEARCH =====
        System.out.println("\n=== Binary Search (O(log n)) ===");
        String searchTitle4 = "1984";
        Book found4 = LibrarySearch.binarySearch(books, searchTitle4);
        if (found4 != null) {
            System.out.println("Result: " + found4);
        } else {
            System.out.println("Book not found!");
        }

        String searchTitle5 = "The Catcher in the Rye";
        Book found5 = LibrarySearch.binarySearch(books, searchTitle5);
        if (found5 != null) {
            System.out.println("Result: " + found5);
        } else {
            System.out.println("Book not found!");
        }

        String searchTitle6 = "Unknown Book";
        Book found6 = LibrarySearch.binarySearch(books, searchTitle6);
        if (found6 != null) {
            System.out.println("Result: " + found6);
        } else {
            System.out.println("Book not found!");
        }

        // ===== ANALYSIS =====
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search:");
        System.out.println("  - Best Case: O(1) (found at first position)");
        System.out.println("  - Average Case: O(n) (found in middle)");
        System.out.println("  - Worst Case: O(n) (found at end or not found)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Requirement: No sorting needed");

        System.out.println("\nBinary Search:");
        System.out.println("  - Best Case: O(1) (found at middle)");
        System.out.println("  - Average Case: O(log n) (very fast)");
        System.out.println("  - Worst Case: O(log n) (still very fast)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Requirement: Array MUST be sorted");

        System.out.println("\n=== When to Use Each Algorithm ===");
        System.out.println("Linear Search is preferred when:");
        System.out.println("  1. Data set is small (< 100 items)");
        System.out.println("  2. Data is unsorted");
        System.out.println("  3. You need to search by multiple attributes");
        System.out.println("  4. Data changes frequently (insertion/deletion)");
        System.out.println("  5. Simplicity is more important than speed");

        System.out.println("\nBinary Search is preferred when:");
        System.out.println("  1. Data set is large (> 100 items)");
        System.out.println("  2. Data is already sorted or can be sorted");
        System.out.println("  3. Search operations are frequent");
        System.out.println("  4. Data is relatively static");
        System.out.println("  5. Performance is critical");

        System.out.println("\n=== Library Management Recommendation ===");
        System.out.println("For a library with thousands of books:");
        System.out.println("1. Use Binary Search for title searches (fast)");
        System.out.println("2. Keep books sorted by title");
        System.out.println("3. Use Linear Search for unsorted data");
        System.out.println("4. Consider using HashMap for O(1) search by ID");
    }
}
