import java.util.Arrays;

public class LibrarySearch {

    // ===== LINEAR SEARCH =====
    // Time Complexity: O(n)
    // Searches by title (case-insensitive)
    public static Book linearSearch(Book[] books, String searchTitle) {
        System.out.println("\n--- Linear Search (O(n)) ---");
        System.out.println("Searching for: " + searchTitle);

        int comparisons = 0;
        for (int i = 0; i < books.length; i++) {
            comparisons++;
            if (books[i].getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Found after " + comparisons + " comparisons!");
                return books[i];
            }
        }
        System.out.println("Not found after " + comparisons + " comparisons!");
        return null;
    }

    // ===== BINARY SEARCH =====
    // Time Complexity: O(log n)
    // Requires sorted array by title
    public static Book binarySearch(Book[] books, String searchTitle) {
        System.out.println("\n--- Binary Search (O(log n)) ---");
        System.out.println("Searching for: " + searchTitle);

        // First, sort the books by title
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, (a, b) -> 
            a.getTitle().compareToIgnoreCase(b.getTitle())
        );

        System.out.println("Books sorted by title:");
        for (Book b : sortedBooks) {
            System.out.println("  " + b.getTitle());
        }

        int left = 0;
        int right = sortedBooks.length - 1;
        int comparisons = 0;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(searchTitle);

            if (comparison == 0) {
                System.out.println("Found after " + comparisons + " comparisons!");
                return sortedBooks[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Not found after " + comparisons + " comparisons!");
        return null;
    }

    // ===== DISPLAY BOOKS =====
    public static void displayBooks(Book[] books, String title) {
        System.out.println("\n--- " + title + " ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
