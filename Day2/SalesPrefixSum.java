import java.util.Scanner;
public class SalesPrefixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking input for the number of hours
        System.out.print("Enter the number of hours: ");
        int n = scanner.nextInt();
        // Initializing the arrays
        int[] sales = new int[n];
        int[] prefixSum = new int[n];
        // Taking input for sales per hour
        System.out.println("Enter sales for each hour:");
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
            prefixSum[i] = sales[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }
        // Displaying the prefix sum
        System.out.print("PrefixSum[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSum[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        scanner.close();
    }
}
