package com.example.service;

import com.example.entity.AppUser;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserByIdNotFound() {
        when(userRepository.findById(999L)).thenReturn(java.util.Optional.empty());

        AppUser result = userService.getUserById(999L);
        assertNull(result);
        verify(userRepository).findById(999L);
        
        System.out.println("✅ Exercise 6: Exception handling test passed!");
    }
}
