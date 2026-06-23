public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 6: Proxy Pattern ===\n");

        System.out.println("--- Creating Proxy Images ---");
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        Image image3 = new ProxyImage("photo3.jpg");

        System.out.println("\n--- Images Created But Not Loaded ---");
        System.out.println("(Images are not loaded from remote server yet)");

        System.out.println("\n--- First Display Call (Loads from server) ---");
        System.out.println("Displaying image1:");
        image1.display(); // Loads the image

        System.out.println("\n--- Second Display Call (Uses Cached Image) ---");
        System.out.println("Displaying image1 again:");
        image1.display(); // Uses cached image - no loading

        System.out.println("\n--- Displaying Other Images ---");
        System.out.println("Displaying image2:");
        image2.display(); // Loads image2

        System.out.println("\nDisplaying image3:");
        image3.display(); // Loads image3

        System.out.println("\n--- Displaying image2 again (Cached) ---");
        image2.display(); // Uses cached image2

        System.out.println("\n=== Benefits of Proxy Pattern ===");
        System.out.println("1. Lazy initialization - loads only when needed");
        System.out.println("2. Caching - avoids repeated loading");
        System.out.println("3. Access control - can restrict access");
        System.out.println("4. Logging - can add logging before/after operations");
        System.out.println("5. Performance optimization - reduces network usage");
        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. Virtual Proxy: Lazy loading of images");
        System.out.println("2. Protection Proxy: Access control");
        System.out.println("3. Remote Proxy: Communication with remote objects");
        System.out.println("4. Cache Proxy: Caching results");
    }
}
