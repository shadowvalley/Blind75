/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Set Matrix Zeroes
 */

class Solution {
    // TC -> O(mn)
    // SC -> O(m+n)
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix[0].length;c++) {
                if(matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}