/***
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * Find Minimum in Rotated Sorted Array
 */

class Solution {
    // TC -> O(log n)
    public int findMin(int[] nums) {
        int minimum = Integer.MAX_VALUE;

        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;

            // Check for sorted side
            if(nums[low] <= nums[mid]) {

                // Since this side is sorted, so nums[low] will always be minimum
                minimum = Math.min(minimum, nums[low]);
                low = mid+1;
            } else {
                // Since this side is sorted, so nums[mid] will always be minimum
                minimum = Math.min(minimum, nums[mid]);
                high = mid-1;
            }
        }       
        return minimum; 
    }
}