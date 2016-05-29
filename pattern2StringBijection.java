import java.util.StringTokenizer;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int patLen = pattern.length();
        if (patLen == 0 || str.length() == 0) {
            return false;
        }
        char[] patChars = pattern.toCharArray();
        StringTokenizer st = new StringTokenizer(str);
        if (patLen != st.countTokens()) {
            return false;
        }
        HashMap<Character, String> pat2Word = new HashMap<Character, String>();
        int i = 0;
        while (i < patLen) {
            String word = (String)st.nextElement();
            if (pat2Word.containsKey(patChars[i])) {
                if (!(pat2Word.get(patChars[i])).equals(word)) {
                    return false;
                }
            } else {
                if (pat2Word.containsValue(word)) {
                    return false;
                } else {
                    pat2Word.put(patChars[i], word);
                }
            }
            i++;
        }
        return true;
    }
}
