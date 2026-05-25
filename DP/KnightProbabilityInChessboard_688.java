import java.util.Arrays;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/description/
 */
public class KnightProbabilityInChessboard_688 {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(n, k, row, column, dp);
    }

    private static double solve(int n, int k, int x, int y, double[][][] dp) {
        if (k == 0) {
            return 1;
        }
        if(dp[x][y][k] != -1) {
            return dp[x][y][k];
        }

        int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        double ans = 0;
        for (int i = 0; i < dx.length; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if (isValid(X, Y, n)) {
                ans += 0.125 * solve(n, k-1, X, Y, dp);
            }
        }

        dp[x][y][k] = ans;
        return ans;
    }

    private static boolean isValid(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
//        int n = 3, k = 2, row = 0, column = 0;
//        int n = 1, k = 0, row = 0, column = 0;
        int n = 8, k = 30, row = 6, column = 4;
        System.out.println(KnightProbabilityInChessboard_688.knightProbability(n, k, row, column));
    }

}
