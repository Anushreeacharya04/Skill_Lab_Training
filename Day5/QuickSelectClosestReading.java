import java.util.Scanner;

public class QuickSelectClosestReading {
    public static int partition(int[][] arr, int low, int high) {
        int pivot = arr[high][1];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j][1] <= pivot) {
                i++;
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static int quickSelect(int[][] arr, int low, int high, int k) {
        if (low <= high) {
            int pi = partition(arr, low, high);
            if (pi == k) {
                return arr[pi][0];
            } else if (pi > k) {
                return quickSelect(arr, low, pi - 1, k);
            } else {
                return quickSelect(arr, pi + 1, high, k);
            }
        }
        return -1;
    }

    public static int findKthClosest(int[] readings, int target, int k) {
        int n = readings.length;
        int[][] diffArray = new int[n][2];
        for (int i = 1; i < n; i++) {
            diffArray[i][0] = readings[i];
            diffArray[i][1] = Math.abs(readings[i] - target);
        }
        return quickSelect(diffArray, 0, n - 1, k - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of readings: ");
        int n = scanner.nextInt();
        int[] readings = new int[n];
        System.out.println("Enter the readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        scanner.close();
        
        int result = findKthClosest(readings, target, k);
        System.out.println("The " + k + "-th closest reading is: " + result);
    }
}
