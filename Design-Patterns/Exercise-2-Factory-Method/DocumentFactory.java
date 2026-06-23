public class DocumentFactory {
    public static Document createDocument(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "word": return new WordDocument();
            case "pdf": return new PdfDocument();
            case "excel": return new ExcelDocument();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
