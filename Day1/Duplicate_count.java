public class Duplicate_count {
    public static void main(String[] args) {
        // an example array elements
        int[] arr = {1, 1, 2, 2, 3, 3, 3};
        
        // iterating through the array
        for (int i = 0; i < arr.length; i++) {
            // Skip the element if it's already checked
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not checked, count number of occurences
            if (!isDuplicate) {
                int count = 1;  // Start with the current number
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] == arr[k]) {
                        count++;  // Increment count for every duplicate
                    }
                }
                // printing of number along with its count
                System.out.println("Number: " + arr[i] + ", Count: " + count);
            }
        }
    }
}
