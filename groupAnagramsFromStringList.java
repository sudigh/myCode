public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs) {
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(String key : map.keySet()) {
		    Collections.sort(map.get(key));
	    }
	    return new ArrayList<List<String>>(map.values());
    }
}
