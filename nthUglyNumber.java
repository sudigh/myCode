/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
REF : Using DP. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to 
     three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiplied by 2, 3, 5. Then we 
     use similar merge method as merge sort to get every ugly number from the three subsequences. 
     At each step we choose the smallest one, and move one step after.
*/
import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        Vector<Integer> uglys = new Vector<Integer>(n);
        uglys.addElement(1);
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(Math.min(uglys.elementAt(i2)*2, uglys.elementAt(i3)*3), uglys.elementAt(i5)*5);
            if (tmp%2 == 0) i2++;
            if (tmp%3 == 0) i3++;
            if (tmp%5 == 0) i5++;
            uglys.addElement(tmp);
        }
        return uglys.lastElement();
    }
}
