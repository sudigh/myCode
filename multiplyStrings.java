/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
REF : Start from right to left, perform multiplication on every pair of digits, and add them together. 
From the following draft, we can immediately conclude:
https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
 
*/
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] pos = new int[n1 + n2];
        for (int i = n1-1; i >= 0; i--) {
            for (int j = n2-1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + pos[p2];
                pos[p1] += sum/10;
                pos[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p); // Omit leading 0
        }
        return ((sb.length() == 0) ? "0" : sb.toString());
    }
}
