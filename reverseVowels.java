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
    System.out.println(reverseVowels(s));
  }
  public static String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        int i = 0, j = sChar.length-1;
        boolean exch = false;
        while (i <= j) {
            char tmp = '\0';
            if (isVowel(sChar[i])) {
                tmp = sChar[i];
                exch = true;
            } else {
                i++;
            }
            if (isVowel(sChar[j])) {
                if (exch) {
                    sChar[i] = sChar[j];
                    sChar[j] = tmp;
                    i++; j--;
                    exch = false;
                } else {
                    continue;
                }
            } else {
                j--;
            }
        }
        return(String.valueOf(sChar));
  }
  public static boolean isVowel(char c) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c =='O' || c == 'U') {
          return true;
      }
      return false;
  }
}
