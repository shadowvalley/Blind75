/**
 * https://leetcode.com/problems/merge-intervals/description/
 * Merge Intervals
 */

class Solution {
    // Approach - 1 -> O(nlogn) + O(2n) (2n as every element is touched 2 times).
    public int[][] merge(int[][] intervals) {
        // Step -1 : Group the closer intervals by sorting based on start idx
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // Step - 2 : Check for overlaps
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // Case -1 -> If ith interval is already a part of the prev interval
            // Case -2 -> It may need to be merged

            // Case -1 // Skip all the already merged intervals
            if(!ans.isEmpty() && ans.get(ans.size()-1).get(1) >= end) {
                continue;
            }

            // Case -2 -> Check the remaining intervals (Merge overlapping intervals)
            for(int j = i+1; j< intervals.length; j++) {
                if(intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return convertTo2DArray(ans);
    }
}


// Approach - 2
class Solution {
    // TC -> O(nlogn)
    public int[][] merge(int[][] intervals) {
        // O(nlogn)
         Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<int[]> ans = new LinkedList<>();
        // O(n)
        for(int[] interval: intervals) {
            // if the current interval does not
            // lie in the last interval:
            if(ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}