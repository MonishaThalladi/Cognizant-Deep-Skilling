public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the payment strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("Payment strategy set to: " + paymentStrategy.getClass().getSimpleName());
    }

    // Execute the payment
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
            return;
        }
        System.out.println("\n--- Executing Payment ---");
        paymentStrategy.pay(amount);
        System.out.println("Payment completed!\n");
    }
}
