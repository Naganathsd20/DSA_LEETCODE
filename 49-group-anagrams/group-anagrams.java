import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case: empty input
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // Map to store sorted string -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort the string to create a unique key
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            
            // Add string to map
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        
        // Return all values from the map
        return new ArrayList<>(map.values());
    }
}
