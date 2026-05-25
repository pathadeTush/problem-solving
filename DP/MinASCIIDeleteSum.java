import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 */
public class MinASCIIDeleteSum {

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return solve(s1, s2, 0, 0, m, n, dp);
    }

    public static int solve(String s1, String s2, int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n) {
            return Math.max(charSum(i, m, s1), charSum(j, n, s2));
        }
        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, i+1, j+1, m, n, dp);
        } else {
            // Delete character from s1
            int ans1 = s1.charAt(i) + solve(s1, s2, i+1, j, m, n, dp);
            // Delete character from s2
            int ans2 = s2.charAt(j) + solve(s1, s2, i, j+1, m, n, dp);
            return dp[i][j] = Math.min(ans1, ans2);
        }
    }

    public static int charSum(int idx, int n, String s) {
        int sum = 0;
        for(int i = idx; i < n; i++) {
            sum += s.charAt(i);
        }
        return sum;
    }

    public static void main(String[] args) {
//        String s1 = "sea";
//        String s2 = "eat";
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(MinASCIIDeleteSum.minimumDeleteSum(s1, s2));
    }

}
