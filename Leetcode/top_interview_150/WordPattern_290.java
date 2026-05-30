package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int wordsLen = words.length;
        int patternLen = pattern.length();
        if (wordsLen != patternLen) return false;

        Map<Character, String> mappingPatternToWord = new HashMap<>();
        Map<String, Character> mappingWordToPattern = new HashMap<>();
        for (int i = 0; i < patternLen; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (!mappingPatternToWord.containsKey(ch)) {
                if (!mappingWordToPattern.containsKey(word)) {
                    mappingPatternToWord.put(ch, word);
                    mappingWordToPattern.put(word, ch);
                } else {
                    return false;
                }
            } else if(!mappingPatternToWord.get(ch).equals(word)) {
                return false;
            }
        }

        return true;
    }

}
