/* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/
// REF : https://discuss.leetcode.com/topic/6186/java-backtracking-solution/4 
// Uses backtracking
public class Solution {
    public boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
    public void getPartitions(List<List<String>> list, List<String> eachPartition, String s, int pos) {
        if (pos == s.length()) {
            list.add(new ArrayList<String>(eachPartition));
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                eachPartition.add(s.substring(pos, i+1));
                getPartitions(list, eachPartition, s, i+1);
                eachPartition.remove(eachPartition.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        getPartitions(list, new ArrayList<String>(), s, 0);
        return list;
    }
}
