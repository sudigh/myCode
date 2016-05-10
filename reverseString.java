import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    String s = "Hi there!";
    System.out.println(s);
    System.out.println(reverseString(s));
  }
  public static String reverseString(String s) {
        char[] sChar = s.toCharArray();
        int i = 0, j = sChar.length-1;
        while (i <= j) {
          char tmp = sChar[i];
          sChar[i] = sChar[j];
          sChar[j] = tmp;
          i++; j--;
        }
    return(String.valueOf(sChar));
  }
}
