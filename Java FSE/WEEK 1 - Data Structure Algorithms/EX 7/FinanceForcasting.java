import java.util.*;
public class FinancialForecasting {
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }
    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = calculateFutureValueOptimized(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current value: ");
        double currentValue = scanner.nextDouble();
        System.out.print("Enter the annual growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future value (recursive): " + futureValue);
        double[] memo = new double[years + 1];
        double futureValueOptimized = calculateFutureValueOptimized(currentValue, growthRate, years, memo);
        System.out.println("Future value (optimized recursive): " + futureValueOptimized);
        scanner.close();
    }
}