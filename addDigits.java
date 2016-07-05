public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return num;
        }
        while(num/10 != 0) {
            num = num%10 + num/10;
        }
        return num%10;
    }
}
