import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void findWaysForCoinChange(int amount, int[]coins) {
        long[][] sol = new long[coins.length + 1][amount + 1];
        // If amount is 0, return empty set
        for (int i = 0; i <= coins.length; i++) {
            sol[i][0] = 1;
        }
        // If number of coins is 0, 0 ways to return change
        for (int j = 1; j <= amount; j++) {
            sol[0][j] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] <= j) { // If coin value is less than amount
                    // reduce the amount by coin value and
					// use the subproblem solution (amount-coins[i]) and
					// add the solution from the top (above row) to it
                    sol[i][j] = sol[i-1][j] + sol[i][j-coins[i-1]];
                } else {
                    sol[i][j] = sol[i - 1][j]; // Copy the value from the top
                }
            }
        }
        System.out.println(sol[coins.length][amount]);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int coinTypes = scanner.nextInt();
        int[] coins = new int[coinTypes];
        for (int i = 0; i < coinTypes; i++) {
            coins[i] = scanner.nextInt();
        }
        findWaysForCoinChange(amount, coins);
    }
}
