package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private OrderService orderService;

    // Test 1: Verify email sent once
    @Test
    void testPlaceOrderEmailSent() {
        orderService.placeOrder("customer@email.com", "ORD-123");

        // Verify email was sent exactly once
        verify(notificationService, times(1))
            .sendEmail("customer@email.com", "Your order ORD-123 has been placed.");
        
        // Verify SMS was never sent
        verify(notificationService, never()).sendSMS(anyString(), anyString());
        
        System.out.println("✅ testPlaceOrderEmailSent passed!");
    }

    // Test 2: Verify email and SMS sent for shipping
    @Test
    void testShipOrderNotifications() {
        orderService.shipOrder("customer@email.com", "9876543210", "ORD-456");

        // Verify email sent once
        verify(notificationService, times(1))
            .sendEmail("customer@email.com", "Your order ORD-456 has been shipped.");
        
        // Verify SMS sent once
        verify(notificationService, times(1))
            .sendSMS("9876543210", "Your order ORD-456 has been shipped.");
        
        System.out.println("✅ testShipOrderNotifications passed!");
    }

    // Test 3: Verify all three notifications sent
    @Test
    void testNotifyDeliveryAllChannels() {
        orderService.notifyDelivery(
            "customer@email.com", 
            "9876543210", 
            "device-123", 
            "ORD-789"
        );

        // Verify email sent once
        verify(notificationService, times(1))
            .sendEmail("customer@email.com", "Your order ORD-789 will be delivered today.");
        
        // Verify SMS sent once
        verify(notificationService, times(1))
            .sendSMS("9876543210", "Your order ORD-789 will be delivered today.");
        
        // Verify push notification sent once
        verify(notificationService, times(1))
            .sendPushNotification("device-123", "Your order ORD-789 will be delivered today.");
        
        System.out.println("✅ testNotifyDeliveryAllChannels passed!");
    }

    // Test 4: Verify total interactions
    @Test
    void testTotalInteractions() {
        orderService.placeOrder("a@email.com", "ORD-1");
        orderService.shipOrder("b@email.com", "1111111111", "ORD-2");
        orderService.notifyDelivery("c@email.com", "2222222222", "device-3", "ORD-3");

        // Verify total interactions with notificationService
        verify(notificationService, times(3)).sendEmail(anyString(), anyString());
        verify(notificationService, times(2)).sendSMS(anyString(), anyString());
        verify(notificationService, times(1)).sendPushNotification(anyString(), anyString());
        
        System.out.println("✅ testTotalInteractions passed!");
    }

    // Test 5: Verify no interactions
    @Test
    void testNoInteractions() {
        // No method calls made

        verifyNoInteractions(notificationService);
        
        System.out.println("✅ testNoInteractions passed!");
    }

    // Test 6: Verify at least once
    @Test
    void testAtLeastOnce() {
        orderService.placeOrder("test@email.com", "ORD-100");

        verify(notificationService, atLeastOnce())
            .sendEmail(anyString(), anyString());
        
        System.out.println("✅ testAtLeastOnce passed!");
    }
}
