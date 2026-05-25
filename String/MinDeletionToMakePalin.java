public class MinDeletionToMakePalin {

    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i != 0 && j != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else if (i != 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if(j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static int minDeletions(String str, int n) {
        return n - lcs(str, new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        String str = "aebcbda";
        System.out.println(minDeletions(str, str.length()));
    }

}
