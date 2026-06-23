public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Executing Light OFF command...");
        light.turnOff();
    }

    @Override
    public void undo() {
        System.out.println("Undoing Light OFF command...");
        light.turnOn();
    }
}
