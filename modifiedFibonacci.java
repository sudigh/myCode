import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static BigInteger findNth(BigInteger t0, BigInteger t1, int idx) {
        int count = 0, tNext = 0;
        BigInteger first = t0, second = t1, next = new BigInteger("0");
        for (int i = 2; i < idx; i++) {
            next = second.multiply(second).add(first); 
            first = second;
            second = next;
        }
        return second;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        BigInteger t0 = scanner.nextBigInteger(), t1 = scanner.nextBigInteger();
        int n = scanner.nextInt();
        System.out.println(findNth(t0, t1, n));      
    }
}
