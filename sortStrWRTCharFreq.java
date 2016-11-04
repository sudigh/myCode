/*
Given a string, sort it in decreasing order based on the frequency of characters.
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

public class Solution {
    public String frequencySort(String s) {
        int[] freqArr = new int[256];
        for (char ch : s.toCharArray()) freqArr[ch]++;
        TreeMap<Integer, List<Character>> freq2char = new TreeMap<Integer, List<Character>>();
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > 0) {
                if(!freq2char.containsKey(freqArr[i])) {
                    freq2char.put(freqArr[i], new LinkedList<Character>());
                }
                freq2char.get(freqArr[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (freq2char.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = freq2char.pollLastEntry();
            for (Character ch : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) sb.append(ch);
            }
        }
        return sb.toString();
    }
}
