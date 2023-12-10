/***
 * https://leetcode.com/problems/contains-duplicate/description/
 * Contains Duplicate
 */

class Solution {
    // Approach - 1 Using HashSet
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}


class Solution {
    // Approach - 2 Using Sorting -> O(n) + O(nlogn) = ~ O(n)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // o(nlog n)

        int prev = nums[0];
        for(int i=1; i<nums.length; i++) {  // O(n)
            if(prev == nums[i]) {
                return true;
            }
            prev = nums[i];
        }
        return false;
    }
}