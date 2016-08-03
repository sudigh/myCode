/*
Write a program that prints a staircase of size n.

Input Format

A single integer, n, denoting the size of the staircase.

Output Format

Print a staircase of size n using # symbols and spaces.

Note: The last line must have 0 spaces in it.

Sample Input

6 
Sample Output

     #
    ##
   ###
  ####
 #####
######
Explanation

The staircase is right-aligned, composed of # symbols and spaces, and has a height and width of n = 6.
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
        StringBuilder stairs = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            stairs.append(" ");
        }
        int j = 0;
        for (int i = 1; i <= n; i++) {
            stairs.replace(n-i, n-j, "#");            
            System.out.println(stairs);
            j++;
        }
    }
}
