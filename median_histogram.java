import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  static TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
  static int numElements = 0;
  
  public static double median() {
    
    int sum = 0, idx = 0;
    double median = 0;
    boolean is_even = false;
    if (numElements%2 == 0) {
      is_even = true;
      idx = numElements/2;
    } else {
      idx = (numElements+1)/2;
    }
    
    System.out.println(" is_even : " + is_even);
    for (Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
        int val = e.getValue();
        sum += val;
        if (sum >= idx) {
          if (is_even) {
              if (median == 0) {
                  median = e.getKey();
                  continue;
              } else {
                  median += e.getKey();
                  System.out.println("  2. median : " + median);
                  median /= 2.0;
                  break;
              }
              
          } else {
              median = e.getKey();
              break;
          }
        }
    }
    return median;
    
  } 
  
  public static void addNum(int x) {
    if (treeMap.containsKey(x)) {
      treeMap.put(x, treeMap.get(x) + 1);
    } else {
      treeMap.put(x, 1);
    }
    numElements++;
  }
  
  public static void main(String[] args) {
    
    addNum(1);
    addNum(10);
    addNum(1);
    addNum(6);
    addNum(5);
    addNum(4);
    addNum(3);
    
    System.out.println("Median = " + median());
  } 
  
}
