/***
 * https://leetcode.com/problems/two-sum/description/
 * Two Sum
 */

import java.util.HashMap;

// Brute Force
class Solution {
    // TC -> O(N^2)
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap();
        for (int i=0;i<nums.length;i++) {
            int to_find = target - nums[i];
            if(hmap.containsKey(to_find)) {
                answer[0] = i;
                answer[1] = hmap.get(to_find);
            } else {
                hmap.put(nums[i], i);
            }
        }
        return answer;
    }
}


// Optimized
class Solution {
    // TC -> O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            int to_find = target - nums[i];
            if(hmap.containsKey(to_find)) {
                ans[0] = hmap.get(to_find);
                ans[1] = i;
                break;
            } else {
                hmap.put(nums[i], i);
            }
        }

        return ans;
    }
}