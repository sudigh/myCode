/* Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int slen = s.length(), tlen = t.length(), i = 0, j = 0;
        if (slen != tlen) {
            return false;
        }
        if  (Objects.equals(s, t)) {
            return true;
        }
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>(), tMap = new HashMap<Character, Integer>();
        char schar = s.charAt(0), tchar = t.charAt(0);;
        while (i < slen) {
            schar = s.charAt(i++);
            if (sMap.containsKey(schar)) {
                sMap.put(schar, (int)sMap.get(schar)+1);
            } else {
                sMap.put(schar, 1);
            }
        }
        while (j < tlen) {
           tchar = t.charAt(j++);
           if (tMap.containsKey(tchar)) {
                tMap.put(tchar, (int)tMap.get(tchar)+1);
            } else {
                tMap.put(tchar, 1);
            }
        }
        boolean match = false;
        if (sMap.size() != tMap.size()) {
            return match;
        }
        for (char ch : sMap.keySet()) {
            if (tMap.containsKey(ch) && ((int)tMap.get(ch) == (int)sMap.get(ch))) {
                match = true;
            } else {
                return false;
            }
        }
        return match;
    }
}
