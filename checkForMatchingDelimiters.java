import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static Stack<Character> stk;
  public static void pushOpeningDelimiter(char ch) {
    switch (ch)
    {
        case '{':
        case '(':
        case '[':
            stk.push(ch);
            break;
    }
  }
  
  public static void main(String[] args) {
    String str = "[}";
    stk = new Stack<Character>();
    char[] strArr = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
        pushOpeningDelimiter(strArr[i]);
        if (strArr[i] == '}') {
            char delim = stk.pop();
            if (delim != '{') {
                System.out.println("Unmatched '}'");
                return;
            } 
        }
        if (strArr[i] == ')') {
            char delim = stk.pop();
            if (delim != '(') {
                System.out.println("Unmatched ')'");
                return;
            } 
        }
        if (strArr[i] == ']') {
            char delim = stk.pop();
            if (delim != '[') {
                System.out.println("Unmatched ']'");
                return;
            } 
        }    
    }
    if (!stk.empty()) {
      char delim = stk.pop();
      System.out.println("Unmatched " + delim);
    } else {
      System.out.println("All delimiters matched");
    }
  }
}
