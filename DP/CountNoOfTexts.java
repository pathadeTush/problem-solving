import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-texts/description/
 */
public class CountNoOfTexts {

    // This is just optimization
    static Map<String, Integer> mapping = new HashMap<>(Map.of("2", 0, "22", 1, "222", 2, "3", 3, "33", 4, "333", 5, "4", 6, "44", 7, "444", 8,
            "5", 9));
    static {
        mapping.putAll(Map.of("55", 10, "555", 11, "6", 12, "66", 13, "666", 14, "7", 15, "77", 16, "777", 17, "7777", 18, "8", 19));
        mapping.putAll(Map.of("88", 20, "888", 21, "9", 22, "99", 23, "999", 24, "9999", 25, "", 26));
    }

    public static int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[][] dp = new int[n][27];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) (solve(pressedKeys, 0, "", dp) % (1e9 + 7));
    }

    private static int solve(String pressedKeys, int idx, String prevStr, int[][] dp) {
        if (idx >= pressedKeys.length()) {
            return 1;
        }
        int _mapping = mapping.get(prevStr);
        if(dp[idx][_mapping] != -1) {
            return dp[idx][_mapping];
        }

        char ch = pressedKeys.charAt(idx);
        int ans;
        if (isEligibleToCombineCode(prevStr, ch)) {
            // map ch with prevStr
            int ans1 = (int) (solve(pressedKeys, idx + 1, prevStr + ch, dp) % (1e9 + 7));
            // consider ch as separate code
            int ans2 = (int) (solve(pressedKeys, idx + 1, String.valueOf(ch), dp) % (1e9 + 7));
            ans = (int) ((ans1 + ans2)% (1e9 + 7));
        } else {
            ans = (int) (solve(pressedKeys, idx + 1, String.valueOf(ch), dp) % (1e9 + 7));
        }

        dp[idx][_mapping] = ans;
        return ans;
    }

    private static boolean isEligibleToCombineCode(String prevStr, char ch) {
        if (prevStr.isEmpty()) {
            return false;
        }

        int len = prevStr.length();
        char lastCh = prevStr.charAt(len - 1);
        if (lastCh != ch) {
            return false;
        }
        if (lastCh == '7' || lastCh == '9') {
            if (len >= 4) {
                return false;
            }
        } else if (len >= 3) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        String pressedKeys = "222222222222222222222222222222222222";
//        String pressedKeys = "444479999555588866";
//        String pressedKeys = "79999";
        String pressedKeys = "4444777788889999";
        System.out.println(CountNoOfTexts.countTexts(pressedKeys));
    }

}
