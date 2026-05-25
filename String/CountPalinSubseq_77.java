import java.util.Arrays;

public class CountPalinSubseq_77 {

    private static final long MOD =  1000000007;

    public static boolean isPalin(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /*
    TC: O(2^n x n)
     */
    public static long countPS(String str, int idx, int n, String subSeq) {
        if (idx >= n) {
            return !subSeq.isEmpty() && isPalin(subSeq) ? 1 : 0;
        }

        return (countPS(str, idx + 1, n, subSeq + str.charAt(idx)) % MOD +
                countPS(str, idx + 1, n, subSeq) % MOD) % MOD;
    }
//
//    public static long countPS(String str) {
//        return countPS(str, 0, str.length(), "");
//    }


    /*

     */
    public static long countPS(String str, int i, int j, long[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == j) {
            return dp[i][j] = 1;
        } else if (str.charAt(i) == str.charAt(j)) {
            return dp[i][j]
                    = ((countPS(str, i + 1, j, dp) +
                    countPS(str, i, j - 1, dp) % MOD) + 1) % MOD;
        } else {
            return dp[i][j] = (countPS(str, i + 1, j, dp) +
                    countPS(str, i, j - 1, dp) -
                    countPS(str, i + 1, j - 1, dp) + MOD) % MOD;
        }
    }

    public static long countPS(String str) {
        int len = str.length();
        long[][] dp = new long[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countPS(str, 0, len - 1, dp);
    }

    public static void main(String[] args) {
        // 134217727
        System.out.println(countPS("aaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
