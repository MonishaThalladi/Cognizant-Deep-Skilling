package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    // Test 1: Mocking - find customer by ID
    @Test
    void testGetCustomer() {
        // Arrange - Create a mock customer
        Customer mockCustomer = new Customer(1, "John Doe", "john@email.com");
        
        // Stub - Define what the mock should return
        when(customerRepository.findCustomerById(1)).thenReturn(mockCustomer);

        // Act
        Customer result = customerService.getCustomer(1);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john@email.com", result.getEmail());
        
        // Verify - Check if the method was called
        verify(customerRepository).findCustomerById(1);
        
        System.out.println("✅ testGetCustomer passed!");
    }

    // Test 2: Stubbing - return null when customer not found
    @Test
    void testGetCustomerNotFound() {
        // Stub - Return null when ID not found
        when(customerRepository.findCustomerById(999)).thenReturn(null);

        // Act
        Customer result = customerService.getCustomer(999);

        // Assert
        assertNull(result);
        verify(customerRepository).findCustomerById(999);
        
        System.out.println("✅ testGetCustomerNotFound passed!");
    }

    // Test 3: Stubbing - get customer name
    @Test
    void testGetCustomerName() {
        Customer mockCustomer = new Customer(2, "Jane Smith", "jane@email.com");
        when(customerRepository.findCustomerById(2)).thenReturn(mockCustomer);

        String name = customerService.getCustomerName(2);

        assertEquals("Jane Smith", name);
        verify(customerRepository).findCustomerById(2);
        
        System.out.println("✅ testGetCustomerName passed!");
    }

    // Test 4: Stubbing - delete customer returns true
    @Test
    void testDeleteCustomerSuccess() {
        when(customerRepository.deleteCustomer(1)).thenReturn(true);

        boolean result = customerService.removeCustomer(1);

        assertTrue(result);
        verify(customerRepository).deleteCustomer(1);
        
        System.out.println("✅ testDeleteCustomerSuccess passed!");
    }

    // Test 5: Stubbing - delete customer returns false
    @Test
    void testDeleteCustomerFailure() {
        when(customerRepository.deleteCustomer(999)).thenReturn(false);

        boolean result = customerService.removeCustomer(999);

        assertFalse(result);
        verify(customerRepository).deleteCustomer(999);
        
        System.out.println("✅ testDeleteCustomerFailure passed!");
    }

    // Test 6: Verify method called multiple times
    @Test
    void testVerifyMultipleCalls() {
        when(customerRepository.findCustomerById(1)).thenReturn(new Customer(1, "John", "john@email.com"));

        customerService.getCustomer(1);
        customerService.getCustomerName(1);

        verify(customerRepository, times(2)).findCustomerById(1);
        
        System.out.println("✅ testVerifyMultipleCalls passed!");
    }
}
