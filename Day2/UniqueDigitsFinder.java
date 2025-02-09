import java.util.*;
public class UniqueDigitsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input array size
        System.out.println("Enter the number of elements:");
        int k = scanner.nextInt();
        int[] numbers = new int[k];
        // Input numbers
        System.out.println("Enter " + k + " numbers:");
        for (int i = 0; i < k; i++) {
            numbers[i] = scanner.nextInt();
        }
        // Get unique sorted digits
        List<Integer> result = findUniqueDigits(numbers);
        // Output result
        System.out.println(result);
        scanner.close();
    }

    // Function to find unique digits from the list
    private static List<Integer> findUniqueDigits(int[] numbers) {
        Set<Integer> digitSet = new HashSet<>();
        for (int num : numbers) {
            while (num > 0) {
                digitSet.add(num % 10); // Extract last digit
                num /= 10; // Remove last digit
            }
        }
        // Convert to sorted list
        List<Integer> sortedDigits = new ArrayList<>(digitSet);
        Collections.sort(sortedDigits);
        return sortedDigits;
    }
}

