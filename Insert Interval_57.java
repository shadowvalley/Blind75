/**
 * https://leetcode.com/problems/insert-interval/description/
 * Insert Interval
 */

class Solution {
    // TC -> O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] in : intervals) {
            // if `in` is less than the new interval
            if(in[1] < newInterval[0]) {
                res.add(in);
            } else if(in[0] > newInterval[1]) {
                // if `in` is bigger than the new interval
                res.add(newInterval);
                newInterval = in;
            } else {
                // merge
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}