public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        System.out.println("Proxy created for: " + fileName);
    }

    @Override
    public void display() {
        // Lazy initialization - load only when display() is called
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
