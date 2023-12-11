/**
 * https://leetcode.com/problems/number-of-islands/description/
 * Number of Islands
 */

class Solution {
    // TC -> O(R*C) where R is rows length and C is cols length;
    // SC -> O(R*C) where R is rows length and C is cols length;
    public int numIslands(char[][] grid) {
        int rc = grid.length;
        int cc = grid[0].length;
        int islandsCount = 0;

        // TC -> O(R*C) where R is rows length and C is cols length;
        for(int r=0;r<rc;r++) {
            for(int c=0;c<cc;c++) {
                if(grid[r][c] == '1') {
                    islandsCount += 1;
                    dfs(r, c, grid); 
                }
            }
        }

        return islandsCount;
    }

    // TC -> O(V * 2E)
    private void dfs(int r, int c, char[][]grid) {
        int rc = grid.length;
        int cc = grid[0].length;

        // Check for boundary
        if(r <0 || r >= rc || c < 0 || c >= cc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        // Traverse in all 4 directions
        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);
    }
}