import java.util.*;
interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Word document opened.");
    }
    @Override
    public void close() {
        System.out.println("Word document closed.");
    }
}
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("PDF document opened.");
    }
    @Override
    public void close() {
        System.out.println("PDF document closed.");
    }
}
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Excel document opened.");
    }
    @Override
    public void close() {
        System.out.println("Excel document closed.");
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;
        Document document = null;
        while (true) {
            System.out.println("Choose a document type to create:");
            System.out.println("1. Word Document");
            System.out.println("2. PDF Document");
            System.out.println("3. Excel Document");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    factory = new WordDocumentFactory();
                    break;
                case 2:
                    factory = new PdfDocumentFactory();
                    break;
                case 3:
                    factory = new ExcelDocumentFactory();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue;
            }
            document = factory.createDocument();
            document.open();
            System.out.println("Do you want to close the document? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                document.close();
            } else {
                System.out.println("Document remains open.");
            }
        }
    }
}