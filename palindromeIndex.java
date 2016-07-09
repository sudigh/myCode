import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void palinIndex(String str) {   
        int n = str.length();
        for (int i = 0; i < (n/2); i++) {
            if (str.charAt(i) != str.charAt(n-i-1)) {
                if (str.charAt(i) == str.charAt(n-i-2) && str.charAt(i+1) == str.charAt(n-i-3)) {
    
                    System.out.println(n-i-1);
                } else if (str.charAt(i+1) == str.charAt(n-i-1) && str.charAt(i+2) == str.charAt(n-i-2)) {
                    System.out.println(i);
                }
                return;
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), idx = 0;
        while (idx < num) {
            String myString = scanner.next();
            palinIndex(myString);
            idx++;
        }
    }
}
