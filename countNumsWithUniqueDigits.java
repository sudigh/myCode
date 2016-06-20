public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int totalNums = 10, base = 9, i = 9;
        while (i > 0 && n > 1) {
            base = base * i;
            totalNums += base;
            i--;n--;
        }
        return totalNums;
    }
}
