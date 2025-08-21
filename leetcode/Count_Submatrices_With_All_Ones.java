class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;       // number of rows
        int n = mat[0].length;    // number of cols
        int[][] heights = new int[m][n]; // heights array like histogram

        // Step 1: build heights row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[i][j] = 0; // reset height
                } else {
                    if (i == 0) heights[i][j] = 1;  // first row
                    else heights[i][j] = heights[i - 1][j] + 1; // stack above
                }
            }
        }

        int total = 0;

        // Step 2: for each row, count rectangles ending at that row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // right end of rectangle
                int minHeight = Integer.MAX_VALUE;
                // walk left from column j
                for (int k = j; k >= 0; k--) {
                    if (heights[i][k] == 0) break; // can't extend past 0
                    minHeight = Math.min(minHeight, heights[i][k]);
                    total += minHeight; // add all rectangles of width (j-k+1)
                }
            }
        }

        return total;
    }
}
