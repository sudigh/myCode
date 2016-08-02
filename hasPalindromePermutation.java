/*
Find whether any anagram of the string can be a palindrome or not.
Sample Input : 01

aaabbbb
Sample Output : 01

YES
Explanation 
A palindrome permutation of the given string is bbaaabb. 

Sample Input : 02

cdefghmnopqrstuvw
Sample Output : 02

NO
Explanation 
You can verify that the given string has no palindrome permutation. 

Sample Input : 03

cdcdcdcdeeeef
Sample Output : 03

YES
Explanation 
A palindrome permutation of the given string is ddcceefeeccdd.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans = "YES";
        int[] letter = new int[26];
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        for (int i = 0; i < inputString.length(); i++) {
            letter[inputString.charAt(i) - 'a']++;
        }
        int numOdds = 0;
        for (int i = 0; i < 26; i++) {
            if (letter[i] % 2 == 1) {
                numOdds++;
            }
        }
        if (numOdds > 1) ans = "NO";
        System.out.println(ans);
        myScan.close();
    }
}
