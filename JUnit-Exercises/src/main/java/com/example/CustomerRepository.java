package com.example;

public interface CustomerRepository {
    Customer findCustomerById(int id);
    void saveCustomer(Customer customer);
    boolean deleteCustomer(int id);
}
