public class Solution {
    public int addDigits(int num) {
        // Using congruence formula for digital root of a number
        // D(n) = n%9 if n%9 != 0
        //      = 9 if n%9 == 0
        //      = 0 if n == 0
        return 1+((num-1)%9);
    }
}
