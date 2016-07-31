/*
Print the number of occurances of the string "010" in a given string.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), i = 2, count = 0;
        String B = in.next();
        while(i < B.length()) {
           if (B.charAt(i) == '0' && B.charAt(i-1) == '1' && B.charAt(i-2) == '0') {
               i += 3;
               count++;
           } else {
               i++;
           }         
        }
        System.out.println(count);
    }
}
