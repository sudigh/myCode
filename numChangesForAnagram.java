import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void findNumChanges_Anagram (String str) {
        int n = str.length();
        if (n%2 != 0) {
            System.out.println(-1);
            return;
        }
        int numChanges = 0, idx = 0;
        HashMap<Character, Integer> fMap = new HashMap<Character, Integer>();
        while (idx < n/2) {
            char ch = str.charAt(idx);
            if (!fMap.containsKey(ch)) {
                fMap.put(ch, 1);
            } else {
                fMap.put(ch, fMap.get(ch)+1);
            }
            idx++;
        }
        while (idx < n) {
            char ch = str.charAt(idx);
            if (fMap.containsKey(ch) && fMap.get(ch) > 0) {
                fMap.put(ch, fMap.get(ch)-1);
            } else {
                numChanges++;
            }
            idx++;
        }
        System.out.println(numChanges);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int nTests = scanner.nextInt(), count = 0;
        while (count < nTests) {
            String str = scanner.next();
            findNumChanges_Anagram(str);
            count++;
        }
    }
}
