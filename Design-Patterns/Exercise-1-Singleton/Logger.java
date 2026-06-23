public class Logger {
    // Step 1: Private static instance of the class
    private static Logger instance;

    // Step 2: Private constructor (prevents instantiation from outside)
    private Logger() {
        System.out.println("Logger instance created!");
    }

    // Step 3: Public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Business method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // Method to show instance details
    public void showInstanceInfo() {
        System.out.println("Logger instance: " + this.hashCode());
    }
}
