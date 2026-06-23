public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 7: Observer Pattern ===\n");

        // Create Stock Market
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        // Create Observers
        MobileApp mobileApp1 = new MobileApp("iPhone App");
        MobileApp mobileApp2 = new MobileApp("Android App");
        WebApp webApp1 = new WebApp("Web Browser");
        WebApp webApp2 = new WebApp("Trading Platform");

        // Register Observers
        System.out.println("--- Registering Observers ---");
        appleStock.registerObserver(mobileApp1);
        appleStock.registerObserver(mobileApp2);
        appleStock.registerObserver(webApp1);
        appleStock.registerObserver(webApp2);

        // Update stock price - all observers get notified
        appleStock.setPrice(155.75);

        appleStock.setPrice(162.30);

        // Deregister an observer
        System.out.println("\n--- Deregistering Web Browser ---");
        appleStock.deregisterObserver(webApp1);

        // Update stock price - only remaining observers get notified
        appleStock.setPrice(158.90);

        System.out.println("\n=== Benefits of Observer Pattern ===");
        System.out.println("1. Loose coupling between subject and observers");
        System.out.println("2. Supports broadcast communication");
        System.out.println("3. Easy to add/remove observers at runtime");
        System.out.println("4. Follows Open/Closed Principle");
        System.out.println("5. Observers can react independently");

        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. GUI event listeners (button clicks)");
        System.out.println("2. Stock market monitoring");
        System.out.println("3. News feed updates");
        System.out.println("4. Social media notifications");
        System.out.println("5. Weather station updates");
    }
}
