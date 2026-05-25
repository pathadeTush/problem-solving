import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak_404 {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String sentence = "catsandog";
        System.out.println(wordBreak(sentence, words));
    }

    public static int wordBreak(String sentence, ArrayList<String> dict) {
        HashSet<String> wordSet = new HashSet<>(dict);
        return solve(sentence, wordSet, "", 0) ? 1 : 0;
    }

    public static boolean solve(String sentence, HashSet<String> words, String word, int idx) {
        if (idx >= sentence.length()) {
            return word.isEmpty();
        }

        if (words.contains(word + sentence.charAt(idx))) {
            boolean res = solve(sentence, words, "", idx + 1);
            if(res) {
                return true;
            }
        }

        return solve(sentence, words, word + sentence.charAt(idx), idx + 1);
    }

}
