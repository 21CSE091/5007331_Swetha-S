import java.util.*;
public class ECommerceSearching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();
        Product[] products = new Product[numProducts];
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        //Target ID
        System.out.print("Enter the target product ID for searching: ");
        int targetId = scanner.nextInt();

        // Linear search example
        Product result = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));

        // Binary search example
        Arrays.sort(products, (a, b) -> a.getProductId() - b.getProductId());
        result = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + (result != null ? result : "Product not found"));
    }
}
class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
class SearchAlgorithms {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }
            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}