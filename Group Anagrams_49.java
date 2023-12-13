/**
 * https://leetcode.com/problems/group-anagrams/description/
 * Group Anagrams
 */

class Solution {
    // TC -> O(n.klogk) where k is the length of the longest string
    // SC -> O(n+k) where k is the length of the longest string
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert the char array to a String to use it as a key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if (map.containsKey(key)) {
                List<String> l = map.get(key);
                l.add(s);
                map.put(key, l);
            } else {
                map.put(key, new ArrayList<>(List.of(s)));
            }
        }

        // Add all values from the map to the result list
        ans.addAll(map.values());
        return ans;
    }
}