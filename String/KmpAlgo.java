import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/*
Problem: https://www.geeksforgeeks.org/problems/search-pattern0205/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
 */
public class KmpAlgo {

    /*
    O(n*hasFnTime)
     */
    public ArrayList<Integer> search(String pattern, String text) {
        if (text.length() < pattern.length()) {
            return new ArrayList<>(Collections.emptyList());
        }
        Map<String, Boolean> patternMap = Map.of(pattern, true);

        int patternLen = pattern.length();
        StringBuilder word = new StringBuilder(patternLen);
        for (int i = 0; i < patternLen; i++) {
            word.append(text.charAt(i));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (patternMap.containsKey(word.toString())) {
            ans.add(1);
        }
        for (int i = 1; i <= text.length() - patternLen; i++) {
            word.deleteCharAt(0);
            word.append(text.charAt(patternLen + i - 1));
            if (patternMap.containsKey(word.toString())) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static int[] buildLps(String pattern) {
        int len = pattern.length();
        int[] lps = new int[len];
        lps[0] = 0;
        int longestPrefixLen = 0;
        for (int i = 1; i < len; i++) {
            char ch = pattern.charAt(i);
            if (ch == pattern.charAt(longestPrefixLen)) {
                longestPrefixLen++;
                lps[i] = longestPrefixLen;
            } else {
                lps[i] = 0;
                longestPrefixLen = 0;
            }
        }

        return lps;
    }

//    public static ArrayList<Integer> search(String pattern, String text) {
//        if(text.length() < pattern.length()) {
//            return new ArrayList<>(Collections.emptyList());
//        }
//
//        int[] lps = buildLps(pattern);
//        int i = 0;
//        int wordIdx = 1;
//        ArrayList<Integer> ans = new ArrayList<>();
//        while (i < text.length()) {
//            int idx = i;
//            while (wordIdx-1 < pattern.length()) {
//                if(text.charAt(idx) == pattern.charAt(wordIdx-1)) {
//                    idx++;
//                    wordIdx++;
//                } else {
//                    break;
//                }
//            }
//
//            if(wordIdx == pattern.length()) {
//                ans.add(i);
//            }
//            wordIdx = lps[idx];
//            i += wordIdx;
//        }
//    }

    public static void main(String[] args) {
        String text = "";
        String pattern = "geeksforgeeks";
        System.out.println(Arrays.toString(buildLps(pattern)));
    }

}
