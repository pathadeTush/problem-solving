package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!freq.containsKey(ch) || freq.get(ch) < 1) {
                return false;
            }

            if (freq.get(ch) == 1) {
                freq.remove(ch);
            } else {
                freq.put(ch, freq.get(ch) - 1);
            }
        }

        return freq.isEmpty();
    }

}
