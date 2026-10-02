class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}


    //     dp = new int[m][n];
    //     for(int i=1;i<m;i++){
    //         for(int j=1;j<n;j++){
    //             dp[i-1][j] + dp[i][j-1];
    //         }
    //     }
    //     return solve(0, 0, obstacleGrid);
    // }
    // public int solve(int i, int j, int[][] grid) {
    //     if (i >= grid.length || j >= grid[0].length) {
    //         return 0;
    //     }
    //     if (grid[i][j] == 1) {
    //         return 0;
    //     }
    //     if (i == grid.length - 1 && j == grid[0].length - 1) {
    //         return 1;
    //     }
    //     int right = solve(i, j + 1, grid);
    //     int down  = solve(i + 1, j, grid);

    //     return right + down;
//     }
// }