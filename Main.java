public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 2: E-commerce Platform Search ===\n");

        // Create sample products
        ProductForSearch[] products = {
            new ProductForSearch(1, "Laptop", "Electronics"),
            new ProductForSearch(2, "Book", "Education"),
            new ProductForSearch(3, "Phone", "Electronics"),
            new ProductForSearch(4, "Shoes", "Fashion"),
            new ProductForSearch(5, "Watch", "Accessories"),
            new ProductForSearch(6, "Tablet", "Electronics"),
            new ProductForSearch(7, "Headphones", "Accessories")
        };

        // Display all products
        System.out.println("--- Available Products ---");
        for (ProductForSearch p : products) {
            System.out.println(p);
        }

        // ===== LINEAR SEARCH =====
        System.out.println("\n--- Linear Search (O(n)) ---");
        String searchTerm1 = "Book";
        ProductForSearch found1 = SearchAlgorithms.linearSearch(products, searchTerm1);
        System.out.println("Searching for: " + searchTerm1);
        System.out.println("Result: " + (found1 != null ? found1 : "Not found"));

        String searchTerm2 = "Camera";
        ProductForSearch found2 = SearchAlgorithms.linearSearch(products, searchTerm2);
        System.out.println("Searching for: " + searchTerm2);
        System.out.println("Result: " + (found2 != null ? found2 : "Not found"));

        // ===== BINARY SEARCH =====
        System.out.println("\n--- Binary Search (O(log n)) ---");
        // Sort products by name first
        SearchAlgorithms.sortProductsByName(products);

        System.out.println("Products sorted by name:");
        for (ProductForSearch p : products) {
            System.out.println("  " + p.getProductName());
        }

        String searchTerm3 = "Phone";
        ProductForSearch found3 = SearchAlgorithms.binarySearch(products, searchTerm3);
        System.out.println("\nSearching for: " + searchTerm3);
        System.out.println("Result: " + (found3 != null ? found3 : "Not found"));

        String searchTerm4 = "Laptop";
        ProductForSearch found4 = SearchAlgorithms.binarySearch(products, searchTerm4);
        System.out.println("Searching for: " + searchTerm4);
        System.out.println("Result: " + (found4 != null ? found4 : "Not found"));

        // ===== ANALYSIS =====
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search:");
        System.out.println("  - Best Case: O(1) (found at first position)");
        System.out.println("  - Average Case: O(n) (found in middle)");
        System.out.println("  - Worst Case: O(n) (found at end or not found)");
        System.out.println("  - Suitable for: Small datasets or unsorted data");

        System.out.println("\nBinary Search:");
        System.out.println("  - Best Case: O(1) (found at middle)");
        System.out.println("  - Average Case: O(log n) (very fast)");
        System.out.println("  - Worst Case: O(log n) (still very fast)");
        System.out.println("  - Suitable for: Large datasets (requires sorted data)");

        System.out.println("\n=== Recommendation ===");
        System.out.println("For a large e-commerce platform with millions of products,");
        System.out.println("Binary Search is preferred because:");
        System.out.println("1. It's much faster: O(log n) vs O(n)");
        System.out.println("2. Products can be stored sorted by name");
        System.out.println("3. Search results appear almost instantly");
        System.out.println("\nHowever, Linear Search is still useful for:");
        System.out.println("1. Small product catalogs");
        System.out.println("2. When data is not sorted");
        System.out.println("3. When performing quick, one-time searches");
    }
}
