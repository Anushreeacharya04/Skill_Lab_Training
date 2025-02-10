import java.util.Scanner;

public class DistinctDigitsFinder {

    // Recursive function to extract digits from a number and mark them in digitSeen array
    private static void extractDigits(int number, boolean[] digitSeen) {
        if (number == 0) {
            return;
        }
        int digit = Math.abs(number % 10); // Get the last digit
        digitSeen[digit] = true;           // Mark this digit as seen
        extractDigits(number / 10, digitSeen); // Recur with the remaining number
    }

    // Recursive function to process each number in the array
    private static void findDistinctDigits(int[] numbers, int index, boolean[] digitSeen) {
        if (index == numbers.length) {
            return;
        }
        extractDigits(numbers[index], digitSeen); // Extract digits from the current number
        findDistinctDigits(numbers, index + 1, digitSeen); // Recur for the next number
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int k = scanner.nextInt();
        int[] numbers = new int[k];

        // Input: elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < k; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Array to keep track of seen digits
        boolean[] digitSeen = new boolean[10];

        // Find distinct digits using recursion
        findDistinctDigits(numbers, 0, digitSeen);

        // Output: sorted list of distinct digits
        System.out.print("Distinct digits in the array: ");
        for (int i = 0; i < 10; i++) {
            if (digitSeen[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
