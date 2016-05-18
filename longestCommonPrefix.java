public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].isEmpty() || strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
