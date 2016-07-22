public class Solution {
    public boolean isPerfectSquare(int num) {
        int count = 1;
        while (num > 0) {
            num -= count;
            count += 2;
        }
        return (num == 0);
    }
}
