package com.example;

public class OrderService {
    private NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder(String customerEmail, String orderId) {
        // Process order logic
        notificationService.sendEmail(customerEmail, "Your order " + orderId + " has been placed.");
    }

    public void shipOrder(String customerEmail, String customerPhone, String orderId) {
        notificationService.sendEmail(customerEmail, "Your order " + orderId + " has been shipped.");
        notificationService.sendSMS(customerPhone, "Your order " + orderId + " has been shipped.");
    }

    public void notifyDelivery(String customerEmail, String customerPhone, String deviceId, String orderId) {
        notificationService.sendEmail(customerEmail, "Your order " + orderId + " will be delivered today.");
        notificationService.sendSMS(customerPhone, "Your order " + orderId + " will be delivered today.");
        notificationService.sendPushNotification(deviceId, "Your order " + orderId + " will be delivered today.");
    }
}
