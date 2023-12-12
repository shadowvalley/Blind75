/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Longest Substring Without Repeating Characters 
 */


import java.util.HashSet;
import java.util.Set;

class Solution {
    // TC -> O(n)
    // SC -> O(n)
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l += 1;
            }
                
            set.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}
