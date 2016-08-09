/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
/* REF : Using dynamic programming. Used a dp array of size n + 1 to save subproblem solutions. 
dp[0] is the number of ways to decode an empty string, dp[1] is the number of ways to decode a string of size 1. 
Then check for one digit and two digit combinations and save the results along the way. In the end, dp[n] will 
be the end result. */
public class Solution {
    public int numDecodings(String s) {
       if (s == null || s.length() == 0) return 0;
       int len = s.length();
       int[] dp = new int[len+1];
       dp[0] = 1; dp[1] = (s.charAt(0) == '0') ? 0 : 1;
       for (int i = 2; i <= len; i++) {
           int one_digit = Integer.valueOf(s.substring(i-1, i));
           int two_digits = Integer.valueOf(s.substring(i-2, i));
           if (one_digit > 0 && one_digit <= 9) {
               dp[i] += dp[i-1];
           }
           if (two_digits >= 10 && two_digits <= 26) {
               dp[i] += dp[i-2];
           }
       }
       return dp[len];
    }
}
