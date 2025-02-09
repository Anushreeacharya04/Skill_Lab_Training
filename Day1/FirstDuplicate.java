import java.util.Scanner;
public class FirstDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        // Taking input from user
        System.out.println("Enter the 10 numbers:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // Finding the first duplicate
        int firstDuplicate = -1; // -1 means no duplicate found initially

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) { 
                if (arr[i] == arr[j]) {
                    firstDuplicate = arr[i];
                    break; // Exit inner loop when duplicate is found
                }
            }
            if (firstDuplicate != -1) {
                break; // Exit outer loop as well
            }
        }

        // Print the result
        if (firstDuplicate != -1) {
            System.out.println("First duplicate number is: " + firstDuplicate);
        } else {
            System.out.println("No duplicate found.");
        }

        sc.close();
    }
}