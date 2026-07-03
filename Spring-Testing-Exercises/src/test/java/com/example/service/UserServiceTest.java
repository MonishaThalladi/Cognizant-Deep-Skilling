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
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        AppUser mockUser = new AppUser("John", "john@email.com");
        mockUser.setId(1L);
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(mockUser));

        AppUser result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(userRepository).findById(1L);
        System.out.println("✅ Exercise 2: UserServiceTest passed!");
    }
}
