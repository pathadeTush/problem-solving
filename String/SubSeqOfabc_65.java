import java.util.Arrays;

public class SubSeqOfabc_65 {

    public static int solve(String str, int idx, int count, char prev, String seq, int[][][] dp) {
        if (idx >= str.length()) {
            if (count >= 3) {
                System.out.println(seq);
                return 1;
            }

            return 0;
        }

        char ch = str.charAt(idx);
        int diff = ch - prev;

        if(prev != '#' && dp[idx][count][prev-'a'] != -1) {
            return dp[idx][count][prev-'a'];
        }

        if (prev == '#') {
            if (ch == 'a') {
                return dp[idx][count][0] = takeNotTakeForDiffCh(str, idx, count, prev, ch, seq, dp);
            } else {
                return dp[idx][count][0] = solve(str, idx + 1, count, prev, seq, dp);
            }
        }
        if (diff == 0) {
            return dp[idx][count][prev-'a'] = takeNotTakeForCommonCh(str, idx, count, prev, ch, seq, dp);
        } else if (diff == 1) {
            return dp[idx][count][prev-'a'] = takeNotTakeForDiffCh(str, idx, count, prev, ch, seq, dp);
        } else {
            return dp[idx][count][prev-'a'] = solve(str, idx + 1, count, prev, seq, dp);
        }

    }

    public static int takeNotTakeForCommonCh(String str, int idx, int count, char prev, char ch, String seq, int[][][] dp) {
        // take
        int take = solve(str, idx + 1, count, ch, seq + ch, dp);
        // not take
        int notTake = solve(str, idx + 1, count, prev, seq, dp);

        return take + notTake;
    }

    public static int takeNotTakeForDiffCh(String str, int idx, int count, char prev, char ch, String seq, int[][][] dp) {
        // take
        int take = solve(str, idx + 1, count + 1, ch, seq + ch, dp);
        // not take
        int notTake = solve(str, idx + 1, count, prev, seq, dp);

        return take + notTake;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        int n = str.length();
        int[][][] dp = new int[n][4][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(str, 0, 0, '#', "", dp));
    }

}
