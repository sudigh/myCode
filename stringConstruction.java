/*
Amanda has a string, s , of m lowercase letters that she wants to copy into a new string, p. She can perform the 
following operations any number of times to construct string p :

Append a character to the end of string p at a cost of 1 dollar.
Choose any substring of p and append it to the end of p at no charge.
Given  strings (i.e.,s0, s1, ..., sn ), find and print the minimum cost of copying each si to pi on a new line.

Sample Input

2
abcd
abab
Sample Output

4
2

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String s = in.next();
            int len = s.length(), pos = 1, cost = 0;
            boolean[] letters = new boolean[26]; // Array to set the character already seen to true
            letters[s.charAt(0) - 'a'] = true; cost++; // If character is already copied, set it to true and copy it if it occurs again later at no cost.
            while (pos < len) {
                char c = s.charAt(pos);
                if (!letters[c - 'a']) { // If new character, then increment cost and set it to true 
                    letters[c - 'a'] = true;
                    cost++;
                }
                pos++;
            }
            System.out.println(cost);
        }
    }
}
