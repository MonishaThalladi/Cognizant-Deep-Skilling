public class Computer {
    // Required parameters
    private String cpu;
    private String ram;

    // Optional parameters
    private String storage;
    private String graphicsCard;
    private boolean bluetoothEnabled;

    // Private constructor - only Builder can create
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private String cpu;
        private String ram;

        // Optional parameters - with default values
        private String storage = "256GB SSD";
        private String graphicsCard = "Integrated";
        private boolean bluetoothEnabled = false;

        // Builder constructor - required fields
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // Optional setters - each returns the Builder
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setBluetoothEnabled(boolean enabled) {
            this.bluetoothEnabled = enabled;
            return this;
        }

        // Build method - creates the Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }
}
