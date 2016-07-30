/*
Shil has a string,S , consisting of N lowercase English letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after 1 operation.

Shil wants to reduce S as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Shil out by finding and printing S's non-reducible form!

Note: If the final string is empty, print "Empty String". 
------------------
Sample Input 1
baab
Sample Output 1
Empty String
-------------------
Sample Input 0
aaabccddd
Sample Output 0
abd
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String reduceString(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                str = str.substring(0, i-1) + str.substring(i+1);
                i = 0;
            }
        } 
        return str;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String redStr = reduceString(input);
        if (redStr.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(redStr);
        }
    }
}
