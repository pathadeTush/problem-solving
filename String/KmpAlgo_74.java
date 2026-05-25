import java.util.ArrayList;
import java.util.List;

public class KmpAlgo_74 {

    /*
    O(n*n)
     */
    public static int lps(String s) {
        if (s.length() < 2) {
            return 0;
        }

        int len = s.length();
        StringBuilder prefix = new StringBuilder(s).deleteCharAt(len-1);
        StringBuilder suffix = new StringBuilder(s).deleteCharAt(0);
        while (!prefix.isEmpty() && !suffix.isEmpty()) {
            if(prefix.compareTo(suffix) == 0) {
                return prefix.length();
            } else {
                prefix.deleteCharAt(prefix.length()-1);
                suffix.deleteCharAt(0);
            }
        }

        return 0;
    }

    public static boolean suffixMatched(String s, int suffixIdx) {
        for(int i = suffixIdx; i < s.length(); i++) {
            if(s.charAt(i-suffixIdx) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static int lps2(String s) {
        if (s.length() < 2) {
            return 0;
        }

        int len = s.length();
        List<Integer> firstCharIndices = new ArrayList<>();
        char firstChar = s.charAt(0);
        for(int i = 1; i < len; i++) {
            if(firstChar == s.charAt(i)) {
                firstCharIndices.add(i);
            }
        }

        for(int suffixIdx: firstCharIndices) {
            if(suffixMatched(s, suffixIdx)) {
                return len-suffixIdx;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "abcdadefabgabc";
        System.out.println(lps2(s));
    }

}
