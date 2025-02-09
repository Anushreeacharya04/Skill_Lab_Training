public class Ecommerce {
    public static void main(String[] args) {
        // Array of ratings
        int[] ratings = {5, 3, 4, 3, 2, 1, 4, 3, 2, 5};
        // Variables to track the most frequent rating and its count
        int mostFrequentRating = -1;
        int highestCount = 0;
        // iterating through each rating in the array
        for (int i = 0; i < ratings.length; i++) {
            int currentRating = ratings[i];
            int currentCount = 1;  // Starting with 1 for the current rating
            // Count how many times this rating appears in the rest of the array
            for (int j = i + 1; j < ratings.length; j++) {
                if (ratings[j] == currentRating) {
                    currentCount++;  // Increment count if we find the same rating
                }
            }
            // If this rating has appeared more times than the current most frequent then update it
            if (currentCount > highestCount) {
                mostFrequentRating = currentRating;
                highestCount = currentCount;
            }
        }
        // Output of most frequent rating and how highestcount
        System.out.println("The most frequent rating is " + mostFrequentRating + " with " + highestCount + " occurrences.");
    }
}
