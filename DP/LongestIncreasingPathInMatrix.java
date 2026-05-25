/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class LongestIncreasingPathInMatrix {

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                vis[i][j] = true;
                int maxLength = 1 + solve(i, j, m, n, matrix, vis, dp);
                ans = Math.max(ans, maxLength);
                vis[i][j] = false;
            }
        }

        return ans;
    }

    private static int solve(int x, int y, int m, int n, int[][] matrix, boolean[][] vis, int[][] dp) {
        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int ans = 0;
        for(int i = 0; i < dx.length; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if(isValid(X, Y, m, n) && !vis[X][Y] && matrix[X][Y] > matrix[x][y]) {
                vis[X][Y] = true;
                ans = Math.max(ans, 1 + solve(X, Y, m, n, matrix, vis, dp));
                vis[X][Y] = false;
            }
        }

        return dp[x][y] = ans;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(LongestIncreasingPathInMatrix.longestIncreasingPath(matrix));
    }

}
