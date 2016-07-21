public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int n0 = 0, n1 = 1, n2 = 2, count = 2, numWays = 0;
        while (count < n) { // Same as Fibonacci number, using Dynamic Programming
            numWays = n2 + n1;
            n1 = n2; 
            n2 = numWays; 
            count++;
        }
        return numWays;
    }
}
