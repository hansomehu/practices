package sword2offer;

public class S47_MaxValueOfGifts {

    /*
    https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
    礼物的最大价值，基础动态规划题
    找对它的状态转移方程
    每个格子用来存放到达它的可能路径的最大加和值，这道题是一定要走到右下角的最后一个格子
     */
    private int maxValue(int[][] arr){
        int m = arr.length, n = arr[0].length;

        for (int i = 0; i < m; i++) { // row
            for (int j = 0; j < n; j++) { // column
                if (i == 0 && j == 0) continue; // use original grids to store max value
                if (i == 0) arr[i][j] += arr[i][j-1];
                else if (j == 0) arr[i][j] += arr[i-1][j];
                else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]) + arr[i][j];
            }
        }

        return arr[m-1][n-1];
    }

    private int maxValueCleanVersion(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[m][n];
    }
}
