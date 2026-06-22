import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Product not found!");
        }
    }

    public Product searchProduct(int productId) {
        return inventory.get(productId);
    }

    public void displayAllProducts() {
        System.out.println("\n=== Current Inventory ===");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
