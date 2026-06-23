public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Executing Light ON command...");
        light.turnOn();
    }

    @Override
    public void undo() {
        System.out.println("Undoing Light ON command...");
        light.turnOff();
    }
}
