public class LongestRepeatingSubSeq_64 {

    /*
    Approach: repeating subseq = lcs(str, str) where str[i] != str[j] for i == j
     */
    public static int longestRepeatingSubsequence(String S1, String S2)
    {
        int m = S1.length();
        int n = S2.length();

        // Initializing a matrix of size (m+1)*(n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Building dp[m+1][n+1] in bottom-up fashion
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str = "axxxy";
        System.out.println(longestRepeatingSubsequence(str, str));
    }

}
