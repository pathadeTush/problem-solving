import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/concatenated-words/
 */
public class ConcatenatedWords {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (wordBreak(word, wordSet) >= 2) {
                ans.add(word);
            }
        }

        return ans;
    }

    private static int wordBreak(String s, Set<String> wordSet) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return solve(0, n, 0, s, "", wordSet, dp);
    }

    private static int solve(int idx, int n, int startIdx, String word, String subWord, Set<String> wordSet, Integer[][] dp) {
        if (idx >= n) {
            return subWord.isEmpty() ? 0 : Integer.MIN_VALUE;
        }

        if (dp[idx][startIdx] != null) {
            return dp[idx][startIdx];
        }

        String _subWord = subWord + word.charAt(idx);
        if (wordSet.contains(_subWord)) {
            // break word
            int ans1 = 1 + solve(idx + 1, n, idx + 1, word, "", wordSet, dp);
            // continue
            int ans2 = solve(idx + 1, n, startIdx, word, _subWord, wordSet, dp);
            return dp[idx][startIdx] = Math.max(ans1, ans2);
        } else {
            // continue
            return dp[idx][startIdx] = solve(idx + 1, n, startIdx, word, _subWord, wordSet, dp);
        }
    }

    public static void main(String[] args) {
//        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        String[] words = new String[] {"cat","dog","catdog"};
        System.out.println(ConcatenatedWords.findAllConcatenatedWordsInADict(words));
    }

}
