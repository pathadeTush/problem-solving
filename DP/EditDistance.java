import java.util.Arrays;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(word1, word2, 0, 0, m, n, dp);
    }

    public static int solve(String s1, String s2, int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n) {
            return Math.max(m-i, n-j);
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(s1, s2, i+1, j+1, m, n, dp);
        } else {
            // insert OR delete character
            int ans1 = 1 + solve(s1, s2, i+1, j, m, n, dp);
            int ans2 = 1 + solve(s1, s2, i, j+1, m, n, dp);

            // replace character
            int ans3 = 1 + solve(s1, s2, i+1, j+1, m, n, dp);


            return dp[i][j] = Math.min(Math.min(ans1, ans2), ans3);
        }
    }

    public static void main(String[] args) {
//        String word1 = "horse";
//        String word2 = "ros";
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(EditDistance.minDistance(word1, word2));
    }

}
