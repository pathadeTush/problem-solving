import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        return solve(0, n, 0, s, "", wordSet, dp);
    }

    public static boolean solve(int idx, int n, int startIdx, String word, String subWord, Set<String> wordSet, Boolean[][] dp) {
        if(idx >= n) {
            return subWord.isEmpty();
        }

        if(dp[idx][startIdx] != null) {
            return dp[idx][startIdx];
        }

        if(wordSet.contains(subWord+word.charAt(idx))) {
            // break word
            boolean ans1 = solve(idx+1, n, idx+1, word, "", wordSet, dp);
            // continue
            boolean ans2 = solve(idx+1, n, startIdx, word, subWord+word.charAt(idx), wordSet, dp);
            return dp[idx][startIdx] = ans1 || ans2;
        } else {
            // continue
            return dp[idx][startIdx] = solve(idx+1, n, startIdx, word, subWord+word.charAt(idx), wordSet, dp);
        }
    }

    public static void main(String[] args) {
//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));
//        String s = "applepenapple";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen"));
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(WordBreak.wordBreak(s, wordDict));
    }

}
