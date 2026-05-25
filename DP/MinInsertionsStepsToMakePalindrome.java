import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 */
public class MinInsertionsStepsToMakePalindrome {

    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return n - LCS(s, new StringBuilder(s).reverse().toString(), 0, 0, n, n, dp);
    }

    public static int LCS(String s1, String s2, int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + LCS(s1, s2, i+1, j+1, m, n, dp);
        } else {
            int ans1 = LCS(s1, s2, i+1, j, m, n, dp);
            int ans2 = LCS(s1, s2, i, j+1, m, n, dp);
            return dp[i][j] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        System.out.println(MinInsertionsStepsToMakePalindrome.minInsertions("zjveiiwvc"));
    }

}
