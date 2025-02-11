import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterElement {
    
    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default value is -1
        
        // Call recursive helper function for each element
        for (int i = 0; i < n; i++) {
            result[i] = findNextGreater(arr, i, new int[n]);
        }
        
        return result;
    }
    
    private static int findNextGreater(int[] arr, int index, int[] memo) {
        if (memo[index] != 0) return memo[index]; // Use memoized value if available
        
        for (int j = index + 1; j < arr.length; j++) {
            if (arr[j] > arr[index]) {
                memo[index] = arr[j];
                return arr[j];
            }
        }
        
        memo[index] = -1; // If no greater element is found
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        System.out.println("Next Greater Elements: " + Arrays.toString(findNextGreaterElements(arr)));
    }
}
