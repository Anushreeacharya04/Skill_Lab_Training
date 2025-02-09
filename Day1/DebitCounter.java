import java.util.Scanner;

public class DebitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of transactions:");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter the array of account transactions:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        int debitCount = debit_count(arr);
        System.out.println("Number of debit transactions: " + debitCount);
        
        sc.close();
    }

    public static int debit_count(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) { // Start from index 1 to compare with previous
            if (arr[i] < arr[i - 1]) { // If current transaction is less than previous, it's a debit
                count++;
            }
        }
        return count;
    }
}
