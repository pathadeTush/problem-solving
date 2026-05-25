import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/description/
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        new StringBuilder(text1).reverse();
        return solve(text1, text2, 0, 0, dp);
    }

    public static int solve(String text1, String text2, int i, int j, int[][] dp) {
        int m = text1.length();
        int n = text2.length();

        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans;
        if(text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + solve(text1, text2, i+1, j+1, dp);
        } else {
            int ans1 = solve(text1, text2, i+1, j, dp);
            int ans2 = solve(text1, text2, i, j+1, dp);
            ans = Math.max(ans1, ans2);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonSubsequence.longestCommonSubsequence("abc", "cba"));
    }

}
