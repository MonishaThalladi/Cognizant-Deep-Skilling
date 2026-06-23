public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 11: Dependency Injection Pattern ===\n");

        // ===== WITHOUT DEPENDENCY INJECTION =====
        System.out.println("--- Without DI (Tight Coupling) ---");
        System.out.println("(We would need to create repository inside service)\n");

        // ===== WITH DEPENDENCY INJECTION =====
        System.out.println("--- With DI (Loose Coupling) ---");

        // Step 1: Create the dependency
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Step 2: Inject the dependency into service (Constructor Injection)
        CustomerService service = new CustomerService(repository);

        // Step 3: Use the service
        service.showDependencyInfo();

        // Step 4: Test operations
        System.out.println("\n--- Testing Operations ---");

        // Find customer
        Customer customer1 = service.getCustomerById(1);
        System.out.println("Found: " + customer1);

        Customer customer2 = service.getCustomerById(3);
        System.out.println("Found: " + customer2);

        // Try non-existent customer
        Customer customer3 = service.getCustomerById(5);
        System.out.println("Found: " + customer3);

        // Save new customer
        System.out.println("\n--- Saving New Customer ---");
        Customer newCustomer = new Customer(4, "Alice Wonder", "alice@email.com");
        service.saveCustomer(newCustomer);

        // Display all customers
        service.displayAllCustomers();

        // ===== SHOWING DI ADVANTAGES =====
        System.out.println("\n=== Benefits of Dependency Injection ===");
        System.out.println("1. Loose coupling between classes");
        System.out.println("2. Easier to test (can mock dependencies)");
        System.out.println("3. Better code maintainability");
        System.out.println("4. Follows Single Responsibility Principle");
        System.out.println("5. Makes code more flexible and reusable");

        System.out.println("\n=== Types of Dependency Injection ===");
        System.out.println("1. Constructor Injection (used in this example)");
        System.out.println("2. Setter Injection");
        System.out.println("3. Field Injection");

        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. Spring Framework");
        System.out.println("2. Java EE / Jakarta EE");
        System.out.println("3. Guice");
        System.out.println("4. Dagger");
        System.out.println("5. Enterprise applications");

        System.out.println("\n=== DI vs New Keyword ===");
        System.out.println("Without DI (using 'new'):");
        System.out.println("  - Service creates its own dependencies");
        System.out.println("  - Tightly coupled");
        System.out.println("  - Hard to test");
        System.out.println("  - Hard to change implementations");

        System.out.println("\nWith DI:");
        System.out.println("  - Dependencies are passed from outside");
        System.out.println("  - Loosely coupled");
        System.out.println("  - Easy to test (mock dependencies)");
        System.out.println("  - Easy to swap implementations");

        System.out.println("\n=== How Spring Framework Uses DI ===");
        System.out.println("1. @Autowired annotation");
        System.out.println("2. @Inject annotation");
        System.out.println("3. XML configuration");
        System.out.println("4. Java-based configuration");
        System.out.println("5. Component scanning");
    }
}
