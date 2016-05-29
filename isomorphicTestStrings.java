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
