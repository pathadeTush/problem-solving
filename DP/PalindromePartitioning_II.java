import java.util.Arrays;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 */
public class PalindromePartitioning_II {

    public static int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, n, 0, s, dp)-1;
    }

    private static int solve(int idx, int n, int startIdx, String word, int[][] dp) {
        if (idx >= n) {
            return startIdx == idx ? 0 : Integer.MAX_VALUE;
        }

        if (dp[idx][startIdx] != -1) {
            return dp[idx][startIdx];
        }

        if (isPalindrome(startIdx, idx, word)) {
            // break word
            int ans1 = 1 + solve(idx + 1, n, idx + 1, word, dp);
            // continue
            int ans2 = solve(idx + 1, n, startIdx, word, dp);
            return dp[idx][startIdx] = Math.min(ans1, ans2);
        } else {
            // continue
            return dp[idx][startIdx] = solve(idx + 1, n, startIdx, word, dp);
        }
    }

    private static boolean isPalindrome(int l, int r, String word) {
        while (l < r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(PalindromePartitioning_II.minCut(s));
    }

}
