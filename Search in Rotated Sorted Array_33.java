/***
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Search in Rotated Sorted Array
 */

class Solution {
    // TC -> O(log n)
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                return mid;
            }

            // In a sorted rotated array, one side of mid is always sorted

            // Find the sorted side
            if(nums[low] <= nums[mid]) {
                // Check if target exists here
                if(target >= nums[low] && target <= nums[mid]) {
                    // search in this sorted space where key might be found
                    high = mid-1;
                } else {
                    // search the opposite side
                    low = mid+1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[high]) {
                    // search in this sorted space where key might be found
                    low = mid+1;
                } else {
                    // search the opposite side
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}