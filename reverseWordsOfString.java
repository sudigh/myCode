/* Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space./

public class Solution {
    public String reverseWords(String s) {
        StringBuilder revStr = new StringBuilder();
        boolean addSpace = false;
        for (int start = s.length()-1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            if (addSpace) revStr.append(" ");
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            revStr.append(s.substring(start+1, end+1));
            addSpace = true;
        }
        return revStr.toString();
    }
}
