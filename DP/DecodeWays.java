import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    static int[] code;
    static char none = '-';

    public static int numDecodings(String s) {
        code = new int[27];
        for (int i = 0; i < 27; i++) {
            code[i] = i;
        }
        int[][] dp = new int[s.length()][11];
        for(int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, 0, none, dp);
    }

    private static int solve(String s, int idx, char prev, int[][] dp) {
        int n = s.length();
        if (idx >= n) {
            return 1;
        }
        if(prev == none) {
            if(dp[idx][10] != -1) {
                return dp[idx][10];
            }
        } else if (dp[idx][prev-'0'] != -1) {
            return dp[idx][prev-'0'];
        }

        char ch = s.charAt(idx);
        if (ch == '0') {
            if (prev == none) {
                return 0;
            } else {
                if (26 - (code(prev) * 10 + code(ch)) >= 0) {
                    return solve(s, idx + 1, none, dp);
                } else {
                    return 0;
                }
            }
        } else {
            if (prev == none) {
                return dp[idx][10] = solve(s, idx + 1, ch, dp);
            } else {
                int ans = solve(s, idx + 1, ch, dp);
                if (26 - (code(prev) * 10 + code(ch)) >= 0) {
                    ans += solve(s, idx + 1, none, dp);
                }
                return dp[idx][prev-'0'] = ans;
            }
        }
    }

    private static int code(char ch) {
        return code[ch - '0'];
    }

    public static void main(String[] args) {
        String s = "27";
//        String s = "111111111111111111111111111111111111111111111";
        System.out.println(DecodeWays.numDecodings(s));
    }

}
