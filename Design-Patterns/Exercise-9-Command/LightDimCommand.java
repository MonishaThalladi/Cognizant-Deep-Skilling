public class LightDimCommand implements Command {
    private Light light;
    private int level;

    public LightDimCommand(Light light, int level) {
        this.light = light;
        this.level = level;
    }

    @Override
    public void execute() {
        System.out.println("Executing Light DIM command...");
        light.dim(level);
    }

    @Override
    public void undo() {
        System.out.println("Undoing Light DIM command...");
        System.out.println("Restoring light to previous state...");
        light.turnOn();
    }
}
