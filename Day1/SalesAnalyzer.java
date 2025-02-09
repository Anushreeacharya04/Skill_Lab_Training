import java.util.Scanner;

public class SalesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of days: ");
        int size = scanner.nextInt();
        
        int[] sales = new int[size];
        System.out.println("Enter the sales for each day:");
        for (int i = 0; i < size; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            sales[i] = scanner.nextInt();
        }
        
        int highestSalesDay = findHighestSalesDay(sales);
        System.out.println("The day with the highest sales is: Day " + (highestSalesDay + 1) + " with sales of " + sales[highestSalesDay]);
        
        scanner.close();
    }

    public static int findHighestSalesDay(int[] sales) {
        int maxIndex = 0;
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > sales[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
