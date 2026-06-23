public class CustomerService {
    // Dependency injected via constructor
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("CustomerService created with dependency injection!");
    }

    public Customer getCustomerById(int id) {
        System.out.println("CustomerService: Fetching customer...");
        return customerRepository.findCustomerById(id);
    }

    public void saveCustomer(Customer customer) {
        System.out.println("CustomerService: Saving customer...");
        customerRepository.saveCustomer(customer);
    }

    public void displayAllCustomers() {
        if (customerRepository instanceof CustomerRepositoryImpl) {
            ((CustomerRepositoryImpl) customerRepository).displayAllCustomers();
        }
    }

    // Method to show dependency info
    public void showDependencyInfo() {
        System.out.println("CustomerService is using: " + 
                           customerRepository.getClass().getSimpleName());
    }
}
