public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 8: Strategy Pattern ===\n");

        // Create payment context
        PaymentContext paymentContext = new PaymentContext();

        // Create different payment strategies
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        PaymentStrategy payPal = new PayPalPayment("john.doe@email.com");
        PaymentStrategy crypto = new CryptoPayment("1A2B3C4D5E6F7G8H9I0J");

        // Test Credit Card Payment
        System.out.println("--- Credit Card Payment ---");
        paymentContext.setPaymentStrategy(creditCard);
        paymentContext.executePayment(150.75);

        // Test PayPal Payment
        System.out.println("--- PayPal Payment ---");
        paymentContext.setPaymentStrategy(payPal);
        paymentContext.executePayment(89.50);

        // Test Crypto Payment
        System.out.println("--- Cryptocurrency Payment ---");
        paymentContext.setPaymentStrategy(crypto);
        paymentContext.executePayment(250.00);

        // Change payment method at runtime
        System.out.println("--- Changing Payment Method at Runtime ---");
        System.out.println("Customer wants to switch to PayPal for a new order...");
        paymentContext.setPaymentStrategy(payPal);
        paymentContext.executePayment(45.99);

        System.out.println("\n=== Benefits of Strategy Pattern ===");
        System.out.println("1. Enables runtime switching of algorithms");
        System.out.println("2. Avoids conditional statements (if-else/switch)");
        System.out.println("3. Follows Open/Closed Principle");
        System.out.println("4. Easy to add new payment methods");
        System.out.println("5. Promotes code reusability");

        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. Payment processing systems");
        System.out.println("2. Sort algorithms (Bubble, Quick, Merge)");
        System.out.println("3. Compression algorithms (ZIP, RAR, GZIP)");
        System.out.println("4. Validation strategies (email, phone, SSN)");
        System.out.println("5. Discount strategies (seasonal, loyalty, bulk)");
    }
}
