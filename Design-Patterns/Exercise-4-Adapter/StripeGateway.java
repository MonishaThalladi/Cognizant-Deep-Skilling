public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Processing Stripe payment: $" + amount);
        System.out.println("Stripe payment successful!");
    }
}
