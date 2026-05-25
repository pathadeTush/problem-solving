import java.util.Arrays;

public class LongestPalinSubStr_63 {

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
    Brute Force: Find longest palindromic substring from all possible substring
     */
    public static String longestPalin(String str) {
        int len = str.length();

        int ans = 0;
        String longStr = null;
        for (int i = 0; i < len; i++) {
            StringBuilder subStr = new StringBuilder();
            for (int j = i; j < len; j++) {
                subStr.append(str.charAt(j));
                if (isPalin(subStr.toString()) && ans < subStr.length()) {
                    ans = subStr.length();
                    longStr = subStr.toString();
                }
            }
        }

        return longStr;
    }

    /*
    Reverse String approach won't work here. It works in case on subsequence
     */
    public static String longestCommonSubStr(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        String[][] dp = new String[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], "");
        }

        String longestSubStr = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = String.valueOf(str1.charAt(i));
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i);
                    }
                } else {
                    dp[i][j] = "";
                }

                if (longestSubStr.length() < dp[i][j].length()) {
                    longestSubStr = dp[i][j];
                }
            }
        }

        return longestSubStr;
    }

    public static boolean longestCommonPalinSubStr(String str, int start, int end, Boolean[][] dp) {
        if (start > end) {
            return true;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        if (str.charAt(start) == str.charAt(end)) {
            return dp[start][end] = longestCommonPalinSubStr(str, start + 1, end - 1, dp);
        }

        return dp[start][end] = false;
    }

    /*
    Intuition: for each range(i, j) check if it's palindrome and store maximum of this
     */
    public static void main(String[] args) {
        String str = "otafsngqvoijxuvqbztv";
//        String str = "aaaabbaa";
        int n = str.length();
        Boolean[][] dp = new Boolean[n][n];
        int startIdx = 0;
        int len = 0;
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (longestCommonPalinSubStr(str, start, end, dp)) {
                    if ((end - start + 1) > len) {
                        len = end - start + 1;
                        startIdx = start;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ans.append(str.charAt(startIdx + i));
        }

        System.out.println(ans);
    }

}
