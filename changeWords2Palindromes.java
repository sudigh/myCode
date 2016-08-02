/*
Change all words into palindromes. To do this, he follows two rules:

He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
Sample Input

4
abc
abcba
abcd
cba
Sample Output

2
0
4
2
Explanation

For the first test case, abc -> abb -> aba.
For the second test case, abcba is already a palindromic string.
For the third test case, abcd -> abcc -> abcb -> abca = abca -> abba.
For the fourth test case, cba -> bba -> aba.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), num = 0;
        while (num < n) {
            String str = scanner.next();
            int len = str.length(), l = 0, r = len-1, count = 0;
            while (l < r) {
                if (str.charAt(l) != str.charAt(r)) {
                    count += Math.abs(str.charAt(l) - str.charAt(r));
                }
                l++; r--;
            }
            System.out.println(count);
            num++;
        }
        
    }
}
