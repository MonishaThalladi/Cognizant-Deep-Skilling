public class Main {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 2: Factory Method Pattern ===\n");

        Document word = DocumentFactory.createDocument("word");
        System.out.println("Word Document:");
        word.open(); word.save(); word.close();

        Document pdf = DocumentFactory.createDocument("pdf");
        System.out.println("\nPDF Document:");
        pdf.open(); pdf.save(); pdf.close();

        Document excel = DocumentFactory.createDocument("excel");
        System.out.println("\nExcel Document:");
        excel.open(); excel.save(); excel.close();

        System.out.println("\n=== Benefits of Factory Method ===");
        System.out.println("1. Decouples client from concrete classes");
        System.out.println("2. Centralizes object creation");
        System.out.println("3. Easy to add new document types");
    }
}
