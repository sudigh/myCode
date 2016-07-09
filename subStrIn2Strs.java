import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void commonSubStr(String str1, String str2) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char[] alphs = alphabets.toCharArray();
        for (char c: alphs) {
            if (str1.indexOf(c) != -1 && str2.indexOf(c) != -1) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), idx = 0;
        while (idx < num) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            commonSubStr(str1, str2);
            idx++;
        }
    }
}
