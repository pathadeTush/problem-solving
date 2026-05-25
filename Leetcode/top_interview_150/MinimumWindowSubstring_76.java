package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumWindowSubstring_76 {

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        Map<Character, Integer> freqT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        String ans = "";
        Map<Character, Integer> freq = new HashMap<>();
        int count = 0;
        int startIdx = 0;
        while (i < m) {
            char ch = s.charAt(i);
            if (freqT.containsKey(ch)) {
                int freqCount = freq.getOrDefault(ch, 0) + 1;
                freq.put(ch, freqCount);
                if (freqCount <= freqT.get(ch)) {
                    count++;
                }
            }
            while (count == n && startIdx <= i) {
                if(ans.isBlank() || ans.length() > i+1-startIdx) {
                    ans = s.substring(startIdx, i + 1);
                }
                char removeCh = s.charAt(startIdx);
                startIdx++;
                if (freq.containsKey(removeCh)) {
                    int freqCount = freq.get(removeCh) - 1;
                    if (freqCount == 0) {
                        freq.remove(removeCh);
                    } else {
                        freq.put(removeCh, freq.get(removeCh) - 1);
                    }
                    if(freqCount < freqT.get(removeCh)) {
                        count--;
                    }
                }
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        System.out.println(MinimumWindowSubstring_76.minWindow(s, t));
//        String s = "acbbaca", t = "aba";
//        System.out.println(MinimumWindowSubstring_76.minWindow(s, t));
        String s = "cabwefgewcwaefgcf", t = "cae";
        System.out.println(MinimumWindowSubstring_76.minWindow(s, t));
    }

}
