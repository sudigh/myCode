public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return "0";
        }
        StringBuilder sum = new StringBuilder();
        int aLen = a.length()-1, bLen = b.length()-1, carry = 0;
        while (aLen >= 0 || bLen >= 0 || carry == 1) {
            int aBit = aLen < 0 ? 0 : a.charAt(aLen) - '0';
            int bBit = bLen < 0 ? 0 : b.charAt(bLen) - '0';
            sum.insert(0, (aBit + bBit + carry) % 2);
            carry = (aBit + bBit + carry) / 2;
            aLen--; bLen--;
        }
        return(sum.toString());
    }
}
