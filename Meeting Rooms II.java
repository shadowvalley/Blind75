/**
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 * Meeting Rooms II
 */

class Solution {
    // TC -> O(nlogn)
    public int minMeetingRooms(int[][] intervals) {
        int size = intervals.length;
        int[] start = new int[size];
        int[] end = new int[size];

        // O(n)
        for(int i=0;i<size;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Sort both start and end
        Arrays.sort(start); // O(nlogn)
        Arrays.sort(end); // O(nlogn)

        // Core logic
        int roomCount = 0;
        int maxRooms = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;

        // O(n)
        while(i<size) {
            if(start[i] < end[j]) {
                roomCount += 1;
                i++;
            } else {
                roomCount -= 1;
                j++;
            }
            maxRooms = Math.max(maxRooms, roomCount);
        }
        return maxRooms;
    }
}


