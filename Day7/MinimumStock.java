import java.util.*;
public class MinimumStock {
    public static List<Integer> minStockPrice(int[] prices, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        












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
    }
}