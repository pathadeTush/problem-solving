package top_interview_150;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsSubsequence_392 {

    public static boolean isSubsequence(String s, String t) {
        return solve(s, t, 0, 0);
    }

    private static boolean solve(String s, String t, int i, int j) {
        int m = s.length();
        int n = t.length();
        if(i >= m) return true;
        if (j >= n) {
            return false;
        }

        boolean ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1);
        } else {
            ans = solve(s, t, i, j+1);
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "abc", t = "ahbgdc";
//        System.out.println(IsSubsequence_392.isSubsequence(s, t));
        String s = "acd", t = "hbagcd";
        System.out.println(IsSubsequence_392.isSubsequence(s, t));
    }

}
