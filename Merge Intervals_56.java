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
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            // if the current interval does not
            // lie in the last interval:
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }
        return convertTo2DArray(ans);
    }
}


// Util 
public static int[][] convertTo2DArray(List<List<Integer>> ans) {
    int numRows = ans.size();
    int[][] resultArray = new int[numRows][];

    for (int i = 0; i < numRows; i++) {
        List<Integer> rowList = ans.get(i);
        int numCols = rowList.size();
        resultArray[i] = new int[numCols];

        for (int j = 0; j < numCols; j++) {
            resultArray[i][j] = rowList.get(j);
        }
    }

    return resultArray;
}