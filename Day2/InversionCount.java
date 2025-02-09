import java.util.Scanner;
public class InversionCount {
    public static int countInversions(int[] arr) {
        int count = 0;
       if (arr.length < 2) {
            System.out.println("No inversions possible with less than 2 elements.");
            return 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) { 
                if (arr[i] > arr[j]) { // True inversion condition
                    System.out.println("Inversion found: (" + arr[i] + ", " + arr[j] + ")");
                    count++;
            } }}
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Taking input for array size
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input! Number of elements should be greater than 0.");
            scanner.close();
            return;
        }
        int[] P = new int[n];
        // Taking input for array elements
        System.out.println("Enter " + n + " processing times:");
        for (int i = 0; i < n; i++) {
            P[i] = scanner.nextInt();
        }
        // Counting inversions
        int inversionCount = countInversions(P);
        System.out.println("Total inversion count: " + inversionCount);
        scanner.close();
 }
}
