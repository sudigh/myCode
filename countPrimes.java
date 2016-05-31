import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
import java.util.Arrays;
class Solution {
  public static void main(String[] args) {
   
    System.out.println("Primes within 100 : " + countPrimes(100));
  }
  public static int countPrimes(int n) { // Using Sieve of Eratosthenes
      boolean[] primes = new boolean[n+1];
      Arrays.fill(primes, true);
      int count = 0;
      for (int i = 2; i*i <= n; i++) {
          if (primes[i]) {           
              for (int j = i*i; j <= n; j += i) {
                  primes[j] = false;
              }
          }
      }
      System.out.println("____________\n Primes : ");
      for(int i = 2; i <= n; i++) {
        if (primes[i]) {
          System.out.println(i);
          count++;
        }
      }
      return count;  
  }
}
