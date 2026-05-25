import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_72 {

    public static boolean isWord(Set<String> dict, String word) {
        return dict.contains(word);
    }

    public static boolean solve(int idx, int n, String s, Set<String> dict, String word) {
        if (idx >= n) {
            return dict.contains(word);
        }

        String newWord = word + s.charAt(idx);
        boolean res;
        if (isWord(dict, newWord)) {
            // consider it as word
            boolean res1 = solve(idx + 1, n, s, dict, "");
            if (!res1) {
                // don't consider it as word
                res = solve(idx + 1, n, s, dict, newWord);
            } else {
                res = res1;
            }
        } else {
            res = solve(idx + 1, n, s, dict, newWord);
        }

        return res;
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        return solve(0, s.length(), s, new HashSet<>(dictionary), "") ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "ilikesamsung";
        ArrayList<String> dict = new ArrayList<>(List.of("i", "like", "sam", "sung", "samsung", "mobile"));
        System.out.println(wordBreak(dict.size(), s, dict));
    }

}
