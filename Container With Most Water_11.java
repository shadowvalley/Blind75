/***
 * https://leetcode.com/problems/container-with-most-water/
 * Container With Most Water
 */

class Solution {
    // TC -> O(n)
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while(left <= right) {
            maxWater = Math.max(maxWater, Math.min(height[left], height[right])* (right - left));

            if(height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return maxWater;
    }
}