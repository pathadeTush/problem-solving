import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, m, n, dp);
    }

    private static int solve(int x, int y, int m, int n, int[][] dp) {
        if(x == m-1 && y == n-1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int ans = 0;
        int[] dx = new int[] {1, 0};
        int[] dy = new int[] {0, 1};
        for(int i = 0; i < 2; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if(isValid(X, Y, m, n)) {
                ans += solve(X, Y, m, n, dp);
            }
        }

        return dp[x][y] = ans;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        System.out.println(UniquePaths.uniquePaths(3, 7));
    }

}
