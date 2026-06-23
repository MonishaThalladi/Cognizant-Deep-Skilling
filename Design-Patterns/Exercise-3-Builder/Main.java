public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 3: Builder Pattern ===\n");

        // Computer 1: Basic (only required fields)
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();
        System.out.println("1. Basic Computer:");
        System.out.println(basicComputer);

        // Computer 2: Gaming (all optional fields)
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setBluetoothEnabled(true)
                .build();
        System.out.println("\n2. Gaming Computer:");
        System.out.println(gamingComputer);

        // Computer 3: Office (some optional fields)
        Computer officeComputer = new Computer.Builder("Intel i7", "16GB")
                .setStorage("512GB SSD")
                .setBluetoothEnabled(true)
                .build();
        System.out.println("\n3. Office Computer:");
        System.out.println(officeComputer);

        // Computer 4: Developer (different configuration)
        Computer devComputer = new Computer.Builder("Intel i9", "64GB")
                .setStorage("2TB NVMe SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setBluetoothEnabled(true)
                .build();
        System.out.println("\n4. Developer Computer:");
        System.out.println(devComputer);

        System.out.println("\n=== Benefits of Builder Pattern ===");
        System.out.println("1. Clean and readable object creation");
        System.out.println("2. Supports optional parameters without multiple constructors");
        System.out.println("3. Ensures immutability (no setters needed)");
        System.out.println("4. Reduces constructor overloading (telescoping anti-pattern)");
        System.out.println("5. Easy to add new parameters without breaking existing code");
    }
}
