/**
 * https://leetcode.com/problems/number-of-islands/description/
 * Number of Islands
 */

class Solution {
    // TC -> O(R*C) where R is rows length and C is cols length;
    // SC -> O(R*C) where R is rows length and C is cols length;
    
    int rowCount;
    int colCount;
    
    // Directions array
    int[] rdir = {-1, 0, 1, 0};
    int[] cdir = {0, 1, 0, -1};

    private void dfs(int row, int col, char[][]grid) {
        // Mark grid[row][col] as visited
        grid[row][col] = '0';

        // Traverse all the 4 directions
        for(int i=0;i<4;i++) {
            int nrow = row + rdir[i];
            int ncol = col + cdir[i];

            if(isValid(nrow, ncol) && grid[nrow][ncol] != '0') {
                dfs(nrow, ncol, grid);
            }
        }
    }
    
    public boolean isValid(int row, int col) {
        return row>=0 && row<rowCount && col>=0 && col < colCount;
    }

    public int numIslands(char[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;


        int islandCount = 0;
        for(int r=0;r<rowCount;r++) {
            for(int c=0;c<colCount;c++) {
                if(grid[r][c] == '1') {
                    islandCount ++;
                    // mark the entire island
                    dfs(r, c, grid);
                }
            }
        }
        return islandCount;
    }
}