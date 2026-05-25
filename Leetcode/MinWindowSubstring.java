import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    // Problem: https://leetcode.com/problems/minimum-window-substring/

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }

    // O(n^2)
    public static String minWindow(String s, String t) {
        int n = s.length();

        Map<Character, Integer> freqT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        int mx = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < n; i++) {
            StringBuilder sub = new StringBuilder();
            Map<Character, Integer> freqSub = new HashMap<>(freqT);
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                sub.append(ch);
                if (freqSub.containsKey(ch)) {
                    int count = freqSub.get(ch) - 1;
                    if (count == 0) {
                        freqSub.remove(ch);
                    } else {
                        freqSub.put(ch, count);
                    }
                }

                if (freqSub.isEmpty()) {
                    if (mx > sub.length()) {
                        mx = sub.length();
                        ans = sub.toString();
                    }
                }
            }
        }

        return ans;
    }

    public static String minWindow2(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }

        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int totalChars = t.length();
        String ans = "";
        StringBuilder subStr = new StringBuilder();
        Map<Character, Integer> count = new HashMap<>(tCount);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            subStr.append(ch);

            if (count.containsKey(ch)) {
                int charCount = count.get(ch);
                if (charCount == 0) {
                    char c = subStr.charAt(0);
                } else {
                    count.put(ch, charCount - 1);
                }
            }

            if (count.isEmpty()) {
                System.out.println("found: " + subStr);
                if (subStr.length() < minLen) {
                    minLen = subStr.length();
                    ans = subStr.toString();
                }

                count = new HashMap<>(tCount);

                while (true) {
                    char firstCh = subStr.charAt(0);
                    subStr.deleteCharAt(0);
                    if (count.containsKey(firstCh)) {
                        int charCount = count.get(firstCh) - 1;
                        if (charCount == 0) {
                            count.remove(firstCh);
                        } else {
                            count.put(firstCh, charCount);
                        }
                        break;
                    }
                }

                System.out.println("substr: " + subStr);
            }
        }

        return ans;
    }

}
