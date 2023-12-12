/**
 * https://leetcode.com/problems/valid-anagram/description/
 * Valid Anagram
 */

class Solution {
    // TC -> O(N)
    // SC -> O(1) since charCounter size is constant
    public boolean isAnagram(String s, String t) {
        int[] charCounter = new int[26];

        char[] s_characters = s.toCharArray();
        char[] t_characters = t.toCharArray();

        // O(N)
        for(char c: s_characters) {
            charCounter[c - 'a'] += 1;
        }

        // O(N) 
        for(char c: t_characters) {
            charCounter[c - 'a'] -= 1;

            if(charCounter[c - 'a'] < 0) {
                return false;
            }
        }

        int i = 0;
        boolean isAnagram = true;
        // O(26)
        while(i<26) {
            if(charCounter[i] > 0) {
                isAnagram = false;
                break;
            }
            i+=1;
        }

        return isAnagram;
    }
}