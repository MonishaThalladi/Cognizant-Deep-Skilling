public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 1: Singleton Pattern ===\n");

        // Try to create multiple instances
        System.out.println("--- Getting Logger instances ---");

        // First call - creates the instance
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");
        logger1.showInstanceInfo();

        // Second call - returns the same instance
        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in");
        logger2.showInstanceInfo();

        // Third call - returns the same instance
        Logger logger3 = Logger.getInstance();
        logger3.log("Data saved successfully");
        logger3.showInstanceInfo();

        // Verify all instances are the same
        System.out.println("\n--- Verifying Singleton ---");
        System.out.println("logger1 hash: " + logger1.hashCode());
        System.out.println("logger2 hash: " + logger2.hashCode());
        System.out.println("logger3 hash: " + logger3.hashCode());

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("\n✅ Singleton pattern works! All instances are the same.");
        } else {
            System.out.println("\n❌ Singleton pattern failed! Instances are different.");
        }

        // Try to create using new (will not work because constructor is private)
        // Logger logger4 = new Logger(); // This would cause a compilation error

        System.out.println("\n=== Benefits of Singleton Pattern ===");
        System.out.println("1. Ensures only one instance exists");
        System.out.println("2. Provides global access point");
        System.out.println("3. Saves memory (only one object)");
        System.out.println("4. Prevents multiple instances from causing conflicts");
        System.out.println("5. Useful for logging, database connections, configuration");
    }
}
