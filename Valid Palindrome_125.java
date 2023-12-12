/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * Valid Palindrome
 */

class Solution {
    // TC -> O(n)
    // SC -> O(n)
    public boolean isPalindrome(String s) {
        // S1 -> Santise the input string 
        // TC -> O(n)* O(1) [O(n) -> Traversal, O(1) -> appending to sb]
        StringBuilder input = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                input.append(Character.toLowerCase(c));
            }
        }

        // S2 -> Check for palindrome 
        // TC -> O(n)
        StringBuilder reversed = new StringBuilder(input).reverse(); 

        if(input.toString().equals(reversed.toString())) return true;
        return false;
    }
}