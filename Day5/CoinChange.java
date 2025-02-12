import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int minCoins(int[] coins, int amount, int[] usedCoins) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    usedCoins[i] = coin;
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void printUsedCoins(int amount, int[] usedCoins) {
        if (usedCoins[amount] == 0) {
            System.out.println("No solution possible.");
            return;
        }
        System.out.print("Coins used: ");
        while (amount > 0) {
            System.out.print(usedCoins[amount] + " ");
            amount -= usedCoins[amount];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of coin denominations: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();
        scanner.close();
        
        int[] usedCoins = new int[amount + 1];
        int result = minCoins(coins, amount, usedCoins);
        
        if (result == -1) {
            System.out.println("No solution possible.");
        } else {
            System.out.println("Minimum coins required: " + result);
            printUsedCoins(amount, usedCoins);
        }
    }
}
