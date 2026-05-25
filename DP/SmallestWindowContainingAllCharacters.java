import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
 */
public class SmallestWindowContainingAllCharacters {

    private static class DPKey {
        private int i;
        private int count;
        private int tookFirstChar;
        private int[] pCount;

        public DPKey(int i, int count, int tookFirstChar, int[] pCount) {
            this.i = i;
            this.count = count;
            this.tookFirstChar = tookFirstChar;
            this.pCount = pCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DPKey dpKey = (DPKey) o;
            return i == dpKey.i && count == dpKey.count && tookFirstChar == dpKey.tookFirstChar && Arrays.equals(pCount, dpKey.pCount);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(i, count, tookFirstChar);
            result = 31 * result + Arrays.hashCode(pCount);
            return result;
        }
    }

    public static String minWindow(String s, String p) {
        int m = s.length();
        int[] pCount = new int[26];
        int n = p.length();
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        for(int window = n; window < m; window++) {
            String ans = solve(s, pCount, n, window);
            if(!ans.isEmpty()) {
                return ans;
            }
        }

        return "";
    }

    private static String solve(String s, int[] pCount, int n, int window) {
        for(int i = window; i <= s.length(); i++) {
            if(allCharFound(s, i-window, i-1, n, pCount)) {
                return s.substring(i-window, i);
            }
        }

        return "";
    }

    private static boolean allCharFound(String s, int l, int r, int n, int[] pCount) {
        int[] charCount = Arrays.copyOf(pCount, 26);
        int count = n;
        for(int i = l; i <= r; i++) {
            int idx = s.charAt(i)-'a';
            if(charCount[idx] > 0) {
                charCount[idx]--;
                count--;
            }
        }

        return count == 0;
    }

//    public static String minWindow(String s, String p) {
//        int m = s.length();
//        int[] pCount = new int[26];
//        int count = p.length();
//        for (char ch : p.toCharArray()) {
//            pCount[ch - 'a']++;
//        }
//
//        Map<DPKey, String> dp = new HashMap<>();
//        String ans = solve(s, m, 0, 0, count, pCount, dp);
//        if (ans.contains("A")) {
//            return "";
//        }
//        return ans;
//    }
//
//    private static String solve(String s, int m, int i, int tookFirstChar, int count, int[] pCount, Map<DPKey, String> dp) {
//        if (count == 0) {
//            return "";
//        }
//        if (i >= m) {
//            return "A";
//        }
//
//        DPKey dpKey = new DPKey(i, count, tookFirstChar, pCount);
//        if (dp.containsKey(dpKey)) {
//            return dp.get(dpKey);
//        }
//
//        String ans;
//        boolean presentInP = pCount[s.charAt(i) - 'a'] > 0;
//        if (presentInP) {
//            pCount[s.charAt(i) - 'a']--;
//            String take = s.charAt(i) + solve(s, m, i + 1, 1, count - 1, pCount, dp);
//            pCount[s.charAt(i) - 'a']++;
//            String notTake;
//            if (tookFirstChar == 1) {
//                notTake = s.charAt(i) + solve(s, m, i + 1, 1, count, pCount, dp);
//            } else {
//                notTake = solve(s, m, i + 1, 0, count, pCount, dp);
//            }
//            if (take.contains("A") && notTake.contains("A")) {
//                ans = "A";
//            } else if (take.contains("A")) {
//                ans = notTake;
//            } else if (notTake.contains("A")) {
//                ans = take;
//            } else {
//                if (take.length() <= notTake.length()) {
//                    ans = take;
//                } else {
//                    ans = notTake;
//                }
//            }
//        } else {
//            String notTake;
//            if (tookFirstChar == 1) {
//                notTake = s.charAt(i) + solve(s, m, i + 1, 1, count, pCount, dp);
//            } else {
//                notTake = solve(s, m, i + 1, 0, count, pCount, dp);
//            }
//            if (notTake.contains("A")) {
//                ans = "A";
//            } else {
//                ans = notTake;
//            }
//        }
//        dp.put(dpKey, ans);
//        return ans;
//    }

    public static void main(String[] args) {
        String s = "timetopractice", p = "toc";
//        String s = "zoomlazapzo", p = "oza";
//        String s = "zoom", p = "zooe";
        System.out.println(SmallestWindowContainingAllCharacters.minWindow(s, p));
    }

}
