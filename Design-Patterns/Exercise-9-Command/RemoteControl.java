import java.util.Stack;

public class RemoteControl {
    private Command[] commands;
    private Stack<Command> commandHistory;

    public RemoteControl() {
        commands = new Command[3];
        commandHistory = new Stack<>();
        // Initialize with no commands
        for (int i = 0; i < 3; i++) {
            commands[i] = new NoCommand();
        }
    }

    // Set command at slot
    public void setCommand(int slot, Command command) {
        commands[slot] = command;
        System.out.println("Command set at slot " + slot);
    }

    // Execute command at slot
    public void pressButton(int slot) {
        System.out.println("\n--- Pressing Button " + slot + " ---");
        commands[slot].execute();
        commandHistory.push(commands[slot]);
    }

    // Undo last command
    public void pressUndo() {
        System.out.println("\n--- Pressing UNDO Button ---");
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No commands to undo!");
        }
    }

    // Show history
    public void showHistory() {
        System.out.println("\n--- Command History ---");
        if (commandHistory.isEmpty()) {
            System.out.println("No commands executed yet.");
        } else {
            System.out.println("Number of commands executed: " + commandHistory.size());
        }
    }

    // NoCommand implementation (Null Object Pattern)
    private static class NoCommand implements Command {
        @Override
        public void execute() {
            System.out.println("No command assigned to this slot!");
        }

        @Override
        public void undo() {
            System.out.println("Nothing to undo!");
        }
    }
}
