import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, Customer> database;

    public CustomerRepositoryImpl() {
        database = new HashMap<>();
        // Add some sample data
        database.put(1, new Customer(1, "John Doe", "john@email.com"));
        database.put(2, new Customer(2, "Jane Smith", "jane@email.com"));
        database.put(3, new Customer(3, "Bob Johnson", "bob@email.com"));
        System.out.println("Database initialized with sample customers!");
    }

    @Override
    public Customer findCustomerById(int id) {
        System.out.println("Searching for customer with ID: " + id);
        return database.get(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        database.put(customer.getId(), customer);
        System.out.println("Customer saved: " + customer);
    }

    public void displayAllCustomers() {
        System.out.println("\n--- All Customers in Database ---");
        for (Customer c : database.values()) {
            System.out.println(c);
        }
    }
}
