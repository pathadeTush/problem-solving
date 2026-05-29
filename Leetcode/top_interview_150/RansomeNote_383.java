package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RansomeNote_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!freq.containsKey(ch) || freq.get(ch) < 1) {
                return false;
            }
            freq.put(ch, freq.get(ch) - 1);
        }

        return true;
    }

}
