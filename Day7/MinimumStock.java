import java.util.*;
public class MinimumStock {
    public static List<Integer> minStockPrice(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();//Stores the minimum value
        Deque<Integer> deque = new LinkedList<>();//Stores indexes of potential min values

      for (int i = 0; i < prices.length; i++) {
            // Remove elements from deque that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst(); // Remove from front
            }

            // Remove elements from deque that are greater than current element
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                deque.pollLast(); // Remove from back
            }

            // Add current element index to deque
            deque.offerLast(i);

            // Store result when first valid window is formed
            if (i >= k - 1) {
                result.add(prices[deque.peekFirst()]);
            }
        }

        return result    
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter number of days: ");
    int n = scanner.nextInt();
    int[] prices = new int[n];
    
    System.out.println("Enter stock prices:");
    for (int i = 0; i < n; i++) {
        prices[i] = scanner.nextInt();
    }
    
    System.out.print("Enter window size (k): ");
    int k = scanner.nextInt();
    scanner.close();

    System.out.println(MinimumStock(prices,k));
    }
}
