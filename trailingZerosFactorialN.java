public class Solution {
/* Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.*/
// REF : http://www.purplemath.com/modules/factzero.htm
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 4) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
