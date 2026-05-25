import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return grid[0][0] + solve(0, 0, m, n, grid, dp);
    }

    private static int solve(int x, int y, int m, int n, int[][] grid, int[][] dp) {
        if(x == m-1 && y == n-1) {
            return 0;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int[] dx = new int[] {0, 1};
        int[] dy = new int[] {1, 0};

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < dx.length; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if(isValid(X, Y, m, n)) {
                ans = Math.min(ans, grid[X][Y] + solve(X, Y, m, n, grid, dp));
            }
        }

        return dp[x][y] = ans;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][] {
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}};
        int[][] grid = new int[][] {
                {1, 2, 3},
                {4, 5, 6}};
        System.out.println(MinimumPathSum.minPathSum(grid));
    }

}
