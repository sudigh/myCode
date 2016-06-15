import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  private static int size = 5;
  private static int sum;
  private static ArrayDeque<Integer> window;

  public static void main(String[] args) {
    // String s = "Hi there!";
    // System.out.println(s);
    // System.out.println(reverseVowels(s));
    //size = 5;
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextInt()) {
      int num = scanner.nextInt();
      mAverage(num);
    }
  }
  public Solution (int sz) {
    size = sz;
    sum = 0;
    window = new ArrayDeque<>();
  }
  public static void mAverage (int val) {
    window.add(val);
    if (window.size() > size) {
      sum -= window.remove();
    }
    sum += val;
    if (window.size() == size) {
      System.out.println("Moving average : " + (double)(sum/size));
    }
    // return (double(sum/size));
  }
}
