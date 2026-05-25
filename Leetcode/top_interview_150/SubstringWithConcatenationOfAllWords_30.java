package top_interview_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SubstringWithConcatenationOfAllWords_30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        int totalWords = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i <= n - totalWords * wordLen; i++) {
            int count = totalWords;
            Map<String, Integer> wordFreqMp = new HashMap<>(mp);
            int j = i;
            for (int k = 0; k < totalWords; k++) {
                String word = s.substring(j, j + wordLen);
                if (wordFreqMp.containsKey(word) && wordFreqMp.get(word) > 0) {
                    int freq = wordFreqMp.get(word) - 1;
                    if (freq > 0) {
                        wordFreqMp.put(word, freq);
                    } else {
                        wordFreqMp.remove(word);
                    }
                    count--;
                } else {
                    break;
                }
                j += wordLen;
            }
            if (count == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo", "bar"};
//        System.out.println(SubstringWithConcatenationOfAllWords_30.findSubstring(s, words));
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","word"};
//        System.out.println(SubstringWithConcatenationOfAllWords_30.findSubstring(s, words));
//        String s = "barfoofoobarthefoobarman";
//        String[] words = new String[]{"bar","foo","the"};
//        System.out.println(SubstringWithConcatenationOfAllWords_30.findSubstring(s, words));
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(SubstringWithConcatenationOfAllWords_30.findSubstring(s, words));
    }

}
