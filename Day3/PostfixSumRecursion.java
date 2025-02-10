import java.util.Scanner;

class PostfixSumRecursion {
    
    // Recursive function to compute postfix sum
    private static void computePostfixSum(int[] fuel, int[] postfixSum, int index, int m) {
        // Base case: Last element remains the same
        if (index == m - 1) {
            postfixSum[index] = fuel[index];
        } else {
            // Recursive case: Compute the sum of the current and next element's postfix sum
            computePostfixSum(fuel, postfixSum, index + 1, m);
            postfixSum[index] = fuel[index] + postfixSum[index + 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input size of fuel array
        System.out.print("Enter the number of delivery points: ");
        int m = scanner.nextInt();
        
        int[] fuel = new int[m];
        int[] postfixSum = new int[m];

        // Input fuel consumption data
        System.out.println("Enter fuel consumption for each delivery point:");
        for (int i = 0; i < m; i++) {
            fuel[i] = scanner.nextInt();
        }

        // Compute postfix sum using recursion
        computePostfixSum(fuel, postfixSum, 0, m);
        
        // Output result
        System.out.print("PostfixSum[] = ");
        for (int sum : postfixSum) {
            System.out.print(sum + " ");
        }

        scanner.close();
    }
}
