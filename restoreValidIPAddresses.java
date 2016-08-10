/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new LinkedList<String>();
        int len = s.length();
        for (int i = 1; i < 4; i++) {
            for (int j = i+1; j < i+4; j++) {
                for (int k = j+1; k < j+4 && k < len; k++) {
                    if (len-k > 3) continue;
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        ips.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return ips;
    }
    public boolean isValid(String str) {
        if (str.length() == 0 || str.length() > 3 || (str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }
}
