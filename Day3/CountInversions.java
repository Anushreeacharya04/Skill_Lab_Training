import java.util.Scanner;
class CountInversions {
  private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        int inversions = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                inversions += (leftArray.length - i); 
                for (int p = i; p < leftArray.length; p++) {
                    System.out.println("Inversion: (" + leftArray[p] + ", " + rightArray[j - 1] + ")");
                }
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

        return inversions;
    } 
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int inversions = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            inversions += mergeSortAndCount(arr, left, mid);  
            inversions += mergeSortAndCount(arr, mid + 1, right);
            inversions += mergeAndCount(arr, left, mid, right);
        }
        return inversions;
    }
                                                       
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
    
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Inversion Pairs:");
        int result = mergeSortAndCount(arr, 0, n - 1);
        
  
        System.out.println("Number of inversions: " + result);
        
  
        scanner.close();
    }
}