public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 3: Sorting Customer Orders ===\n");

        Order[] orders = {
            new Order(101, "Alice", 250.50),
            new Order(102, "Bob", 150.00),
            new Order(103, "Charlie", 500.75),
            new Order(104, "Diana", 100.25),
            new Order(105, "Eve", 300.00),
            new Order(106, "Frank", 450.30),
            new Order(107, "Grace", 200.00)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) {
            System.out.println(o);
        }

        // Bubble Sort
        Order[] bubbleOrders = SortingAlgorithms.copyArray(orders);
        System.out.println("\n=== Bubble Sort (O(n²)) ===");
        SortingAlgorithms.bubbleSort(bubbleOrders);
        SortingAlgorithms.displayOrders(bubbleOrders, "After Bubble Sort");

        // Quick Sort
        Order[] quickOrders = SortingAlgorithms.copyArray(orders);
        System.out.println("\n=== Quick Sort (O(n log n)) ===");
        SortingAlgorithms.quickSort(quickOrders, 0, quickOrders.length - 1);
        SortingAlgorithms.displayOrders(quickOrders, "After Quick Sort");

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Bubble Sort: O(n²)");
        System.out.println("Quick Sort: O(n log n)");
        System.out.println("Quick Sort is preferred for large datasets.");
    }
}
