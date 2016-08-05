/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

public class Solution {
    // 1. sum = a, Carry = sum & b
    // 2. sum = sum xor b
    // 3. carry = carry << 1 (carry leftshift by 1)
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int carry = 0, sum = a;
        while (b != 0) {
            carry = sum & b;
            sum = sum ^ b;
            b = carry << 1;
        }
        return sum;
    }
}
