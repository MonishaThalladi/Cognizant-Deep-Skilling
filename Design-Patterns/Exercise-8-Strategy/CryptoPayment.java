public class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Cryptocurrency payment...");
        System.out.println("Wallet Address: " + walletAddress);
        System.out.println("Amount: $" + amount);
        System.out.println("Cryptocurrency payment successful!");
    }
}
