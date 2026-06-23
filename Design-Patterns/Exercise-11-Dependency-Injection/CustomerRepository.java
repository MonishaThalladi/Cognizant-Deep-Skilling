public interface CustomerRepository {
    Customer findCustomerById(int id);
    void saveCustomer(Customer customer);
}
