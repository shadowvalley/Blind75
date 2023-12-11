/***
 * https://leetcode.com/problems/missing-number/
 * Missing Number
 */


class Solution {
    // Approach -1 -> Sort and Find
    // TC -> O(nlog n) + O(n) = ~ O(nlogn)
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int missingNumber = -1;
        int i= 0;
        for(i=0;i<n;i++) {
            if(nums[i] != i) {
                missingNumber = i;
                break;
            } else {
                continue;
            }
        }
        if(i == n) {
            missingNumber = n;
        }

        return missingNumber;
    }
}


class Solution {
    // XOR based approach - O(n)
    public int missingNumber(int[] nums) {
        int xor1 = nums[0];
        int xor2 = 0;

        // Elements XOR O(n)
        for(int i=1;i<nums.length;i++) {
            xor1 ^= nums[i];
        }

        // Index XOR O(n)
        for(int j=1;j<=nums.length;j++) {
            xor2 ^= j;
        }

        // Final answer
        return xor1 ^ xor2;
    }
}