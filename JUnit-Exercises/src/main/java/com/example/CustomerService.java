package com.example;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(int id) {
        return customerRepository.findCustomerById(id);
    }

    public void registerCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    public boolean removeCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    public String getCustomerName(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            return "Customer not found";
        }
        return customer.getName();
    }
}
