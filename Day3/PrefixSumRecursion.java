import java.util.Scanner;

class PrefixSumRecursion {
    
    // Recursive function to compute prefix sum
    private static void computePrefixSum(int[] sales, int[] prefixSum, int index) {
        // Base case: First element remains the same
        if (index == 0) {
            prefixSum[index] = sales[index];
        } else {
            // Recursive case: Add current sales value to previous prefix sum
            computePrefixSum(sales, prefixSum, index - 1);
            prefixSum[index] = prefixSum[index - 1] + sales[index];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input size of sales array
        System.out.print("Enter the number of hours: ");
        int n = scanner.nextInt();
        
        int[] sales = new int[n];
        int[] prefixSum = new int[n];

        // Input sales data
        System.out.println("Enter sales data for each hour:");
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }

        // Compute prefix sum using recursion
        computePrefixSum(sales, prefixSum, n - 1);
        
        // Output result
        System.out.print("PrefixSum[] = ");
        for (int sum : prefixSum) {
            System.out.print(sum + " ");
        }

        scanner.close();
    }
}
