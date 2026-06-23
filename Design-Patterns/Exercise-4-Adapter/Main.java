public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 4: Adapter Pattern ===\n");

        // Create payment gateways
        PayPalGateway payPal = new PayPalGateway();
        StripeGateway stripe = new StripeGateway();

        // Create adapters
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

        // Process payments using adapters
        System.out.println("--- Processing Payments ---");

        System.out.println("\n1. PayPal Payment:");
        payPalAdapter.processPayment(150.00);

        System.out.println("\n2. Stripe Payment:");
        stripeAdapter.processPayment(250.50);

        System.out.println("\n3. Another PayPal Payment:");
        payPalAdapter.processPayment(75.25);

        System.out.println("\n=== Benefits of Adapter Pattern ===");
        System.out.println("1. Allows incompatible interfaces to work together");
        System.out.println("2. Enables integration with third-party libraries");
        System.out.println("3. Promotes code reusability");
        System.out.println("4. Makes system extensible for new payment gateways");
        System.out.println("5. Maintains Single Responsibility Principle");
    }
}
