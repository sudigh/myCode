/* 
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*/
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        
        char[] s2tMap = new char[256];
        char[] t2sMap = new char[256];
        for (int i = 0; i < len; i++) {
            char sch = sCharArr[i], tch = tCharArr[i];
            if (s2tMap[sch] == 0 && t2sMap[tch] == 0) {
                s2tMap[sch] = tch;
                t2sMap[tch] = sch;
            } else {
                if (s2tMap[sch] != tch || t2sMap[tch] != sch) {
                    return false;
                }
            }
        }
        return true;
    }
}
