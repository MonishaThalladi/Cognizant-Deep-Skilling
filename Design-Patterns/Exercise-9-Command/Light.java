public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is turned ON");
    }

    public void turnOff() {
        System.out.println(location + " light is turned OFF");
    }

    public void dim(int level) {
        System.out.println(location + " light dimmed to " + level + "%");
    }
}
