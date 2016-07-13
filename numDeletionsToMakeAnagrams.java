import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void findNumDeletions(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int[] arr = new int[26];
        for (int i = 0; i < n1; i++) {
            arr[str1.charAt(i)-97]++;
        }
        for (int i = 0; i < n2; i++) {
            arr[str2.charAt(i)-97]--;
        }
        int numDels = 0;
        for (int i = 0; i < 26; i++) {
            numDels += Math.abs(arr[i]);
        }
        System.out.println(numDels); 
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        findNumDeletions(str1, str2);
    }
}
