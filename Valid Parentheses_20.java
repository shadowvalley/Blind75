/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * Valid Parentheses
 */

class Solution {
    // TC -> O(N)
    // SC -> O(N)
    public boolean isValid(String s) {
        HashMap<Character, Character> paranMap = new HashMap<>();
        paranMap.put(']', '[');
        paranMap.put('}', '{');
        paranMap.put(')', '(');


        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) { // O(N)
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                st.add(s.charAt(i));
            } else {
                if(!st.empty()) {
                   char top = st.pop();
                    if(paranMap.get(s.charAt(i)) != top) {
                        return false;
                    }
                } else {
                    return false;
                }
            } 
        }

        return st.empty();
        
    }
}
