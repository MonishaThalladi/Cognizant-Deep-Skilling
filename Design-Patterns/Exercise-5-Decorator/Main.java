public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 5: Decorator Pattern ===\n");

        System.out.println("--- Email Only ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello via Email");

        System.out.println("\n--- Email + SMS ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("Hello via Email and SMS");

        System.out.println("\n--- Email + Slack ---");
        Notifier emailAndSlack = new SlackNotifierDecorator(new EmailNotifier());
        emailAndSlack.send("Hello via Email and Slack");

        System.out.println("\n--- Email + SMS + Slack ---");
        Notifier allChannels = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                new EmailNotifier()));
        allChannels.send("Hello via Email, SMS, and Slack");

        System.out.println("\n=== Benefits of Decorator Pattern ===");
        System.out.println("1. Adds functionality dynamically without modifying original class");
        System.out.println("2. Follows Open/Closed Principle");
        System.out.println("3. Flexible combination of behaviors");
        System.out.println("4. Avoids subclass explosion");
        System.out.println("5. Easy to add new notification channels");
    }
}
