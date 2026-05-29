package top_interview_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsomorphicStrings_205 {

//    public boolean isIsomorphic(String s, String t) {
//        int m = s.length();
//        int n = t.length();
//
//        if (m != n) return false;
//
//        Map<Character, Integer> freqS = new HashMap<>();
//        for (char ch : s.toCharArray()) {
//            freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);
//        }
//        Map<Character, Integer> freqT = new HashMap<>();
//        for (char ch : t.toCharArray()) {
//            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
//        }
//
//        if (freqS.size() != freqT.size()) return false;
//        Map<Integer, Integer> freqOfFreqS = new HashMap<>();
//        for (Map.Entry<Character, Integer> entry : freqS.entrySet()) {
//            freqOfFreqS.put(entry.getValue(), freqOfFreqS.getOrDefault(entry.getValue(), 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : freqT.entrySet()) {
//            if (!freqOfFreqS.containsKey(entry.getValue()) || freqOfFreqS.get(entry.getValue()) < 1) {
//                return false;
//            }
//
//            freqOfFreqS.put(entry.getValue(), freqOfFreqS.get(entry.getValue()) - 1);
//        }
//
//        return true;
//    }

    public static boolean isIsomorphic(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m != n) {
            return false;
        }

        String shortenedS = shortenString(s);
        String shortenedT = shortenString(t);
        if (shortenedS.length() != shortenedT.length()) {
            return false;
        }

        Map<Character, Character> mappingS_T = new HashMap<>();
        Map<Character, Character> mappingT_S = new HashMap<>();
        int len = shortenedT.length();
        for (int i = 0; i < len; i += 2) {
            char ch = shortenedT.charAt(i);
            char freq = shortenedT.charAt(i + 1);

            char chS = shortenedS.charAt(i);
            char freqS = shortenedS.charAt(i + 1);
            if (freq != freqS) {
                return false;
            }

            if (!mappingS_T.containsKey(chS)) {
                if (!mappingT_S.containsKey(ch)) {
                    mappingS_T.put(chS, ch);
                    mappingT_S.put(ch, chS);
                } else if (mappingT_S.get(ch) != chS) {
                    return false;
                }
            } else if (mappingS_T.get(chS) != ch) {
                return false;
            }
        }

        return true;
    }

    private static String shortenString(String s) {
        int n = s.length();
        StringBuffer sbS = new StringBuffer();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == prev) {
                count++;
            } else {
                sbS.append(prev);
                sbS.append(count);
                prev = ch;
                count = 1;
            }
        }

        sbS.append(prev);
        sbS.append(count);

        return sbS.toString();
    }

    public static void main(String[] args) {
//        String s = "paper", t = "title";
//        System.out.println(IsomorphicStrings_205.isIsomorphic(s, t));
        String s = "badc", t = "baba";
        System.out.println(IsomorphicStrings_205.isIsomorphic(s, t));
    }

}
