package dp;

public class UniquePath {
	
	
	
	// [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/description/)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = (obstacleGrid[0][0] == 1 ? 0 : 1);
        for (int i = 1; i < m; i ++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 0) {
                dp[i][0] = 1;
            } else {
                while (i<m) {
                    dp[i++][0] = 0;
                }
            }
        }
        for (int j = 1; j < n; j ++) {
            if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 0) {
                dp[0][j] = 1;
            } else {
                while (j<n) {
                    dp[0][j++] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i ++ ) {
            for (int j = 1; j < n; j ++) {
                int x = (obstacleGrid[i-1][j] == 1 ? 0 : dp[i-1][j]);
                int y = (obstacleGrid[i][j-1] == 1 ? 0 : dp[i][j-1]);
                dp[i][j] = (obstacleGrid[i][j] == 1 ? 0 : (x + y));
            }
        }
        return dp[m-1][n-1];
    }
}
