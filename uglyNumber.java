class Solution {
  /* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. */
  public static void main(String[] args) {
   
    System.out.println("11 : " + isUgly(11));
  }
  public static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] divisors = {2, 3, 5};
        for (int divisor : divisors) {
            System.out.println("divisor : " + divisor);
            System.out.println("** num : " + num);
            while(num % divisor == 0) {
                num /= divisor;
                System.out.println("num : " + num);
            }
        }
        return num == 1;
    }
}
