import java.util.*;
class Order {
    int orderId;
    String customerName;
    double totalPrice;
    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    @Override
    public String toString() {
        return "OrderId: " + orderId + ", CustomerName: " + customerName + ", TotalPrice: " + totalPrice;
    }
}
public class SortingCustomerOrders {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice > pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter total price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();
            orders[i] = new Order(orderId, customerName, totalPrice);
        }
        System.out.println("\n Orders before sorting:");
        displayOrders(orders);

        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSortedOrders);
        System.out.println("\n Orders sorted by Bubble Sort:");
        displayOrders(bubbleSortedOrders);

        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        displayOrders(quickSortedOrders);
    }
}