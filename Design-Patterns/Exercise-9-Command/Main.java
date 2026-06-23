public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 9: Command Pattern ===\n");

        // Create Receiver (Light)
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Light bedroomLight = new Light("Bedroom");

        // Create Commands
        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn = new LightOnCommand(kitchenLight);
        Command kitchenOff = new LightOffCommand(kitchenLight);
        Command bedroomDim = new LightDimCommand(bedroomLight, 50);

        // Create Invoker (Remote Control)
        RemoteControl remote = new RemoteControl();

        // Set commands to slots
        System.out.println("--- Setting Up Remote Control ---");
        remote.setCommand(0, livingRoomOn);
        remote.setCommand(1, kitchenOn);
        remote.setCommand(2, bedroomDim);

        // Execute commands
        System.out.println("\n--- Using Remote Control ---");
        remote.pressButton(0);  // Turn on living room light
        remote.pressButton(1);  // Turn on kitchen light
        remote.pressButton(2);  // Dim bedroom light

        // Try empty slot
        System.out.println("\n--- Testing Empty Slot ---");
        remote.pressButton(3);  // No command assigned

        // Undo functionality
        System.out.println("\n--- Undo Functionality ---");
        remote.pressUndo();  // Undo dim command
        remote.pressUndo();  // Undo kitchen on
        remote.pressUndo();  // Undo living room on
        remote.pressUndo();  // No more commands

        // Show history
        remote.showHistory();

        // Reset and try different sequence
        System.out.println("\n--- New Sequence ---");
        remote.setCommand(0, livingRoomOff);
        remote.setCommand(1, kitchenOff);
        remote.pressButton(0);  // Turn off living room
        remote.pressButton(1);  // Turn off kitchen

        System.out.println("\n=== Benefits of Command Pattern ===");
        System.out.println("1. Decouples sender from receiver");
        System.out.println("2. Supports Undo/Redo operations");
        System.out.println("3. Allows queuing of commands");
        System.out.println("4. Supports macro commands");
        System.out.println("5. Follows Open/Closed Principle");

        System.out.println("\n=== Real-world Use Cases ===");
        System.out.println("1. Remote controls (TV, AC, Home Automation)");
        System.out.println("2. Transaction systems (Banking, E-commerce)");
        System.out.println("3. Menu systems (Copy, Paste, Cut)");
        System.out.println("4. Game controls");
        System.out.println("5. Job scheduling systems");
    }
}
