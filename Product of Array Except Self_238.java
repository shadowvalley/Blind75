/***
 * https://leetcode.com/problems/product-of-array-except-self/
 * Product of Array Except Self
 */


class Solution {
    // TC -> O(n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = 1;
        postfix[n-1] = 1;

        // Prefix -> O(n)
        for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // Postfix -> O(n)
        for(int i=n-2;i>=0;i--) {
            postfix[i] = postfix[i+1] * nums[i+1];
        } 

        
        // Combine prefix and postfix -> O(n)
        for(int i=0;i<n;i++) {
            nums[i] = prefix[i] * postfix[i];
        }

        return nums;
    }
}