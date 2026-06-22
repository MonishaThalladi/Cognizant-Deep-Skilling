public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 1: Inventory Management System ===\n");

        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 10, 999.99));
        manager.addProduct(new Product(102, "Mouse", 50, 29.99));
        manager.addProduct(new Product(103, "Keyboard", 30, 79.99));

        manager.displayAllProducts();

        manager.updateProduct(102, 45, 25.99);

        Product found = manager.searchProduct(103);
        System.out.println("\nFound: " + found);

        manager.deleteProduct(101);

        manager.displayAllProducts();

        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Add Product: O(1)");
        System.out.println("Update Product: O(1)");
        System.out.println("Delete Product: O(1)");
        System.out.println("Search Product: O(1)");
        System.out.println("Display All: O(n)");
        System.out.println("\nHashMap is efficient for key-based operations.");
    }
}
