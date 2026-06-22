public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 2: E-commerce Platform Search ===\n");

        ProductForSearch[] products = {
            new ProductForSearch(1, "Laptop", "Electronics"),
            new ProductForSearch(2, "Book", "Education"),
            new ProductForSearch(3, "Phone", "Electronics"),
            new ProductForSearch(4, "Shoes", "Fashion"),
            new ProductForSearch(5, "Watch", "Accessories")
        };

        System.out.println("--- Linear Search (O(n)) ---");
        String searchTerm = "Book";
        ProductForSearch found1 = SearchAlgorithms.linearSearch(products, searchTerm);
        System.out.println("Searching for: " + searchTerm);
        System.out.println("Result: " + (found1 != null ? found1 : "Not found"));

        SearchAlgorithms.sortProductsByName(products);
        System.out.println("\n--- Binary Search (O(log n)) ---");
        searchTerm = "Phone";
        ProductForSearch found2 = SearchAlgorithms.binarySearch(products, searchTerm);
        System.out.println("Searching for: " + searchTerm);
        System.out.println("Result: " + (found2 != null ? found2 : "Not found"));

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search: O(n) - Best for small or unsorted data");
        System.out.println("Binary Search: O(log n) - Best for large sorted data");
        System.out.println("Binary Search is more suitable for large e-commerce platforms.");
    }
}
