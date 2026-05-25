import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SmallestSubstrContainingAllChar_88 {

    /*
    1. put all char to map till we find all char
    2. Now, try to remove unwanted char from map from left till the size of map doesn't change.
    Meanwhile, keep storing min length of window.

    when size reduces means we have remove one char from left.
    repeat 1 and 2
     */
    public static int findSubString(String str) {
        int n = str.length();
        if (n < 2) {
            return n;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            set.add(ch);
        }

        Map<Character, Integer> charFreq = new HashMap<>();
        int i = -1;
        int j = -1;
        int ans = str.length();
        while (i < str.length() - 1) {
            while (i < str.length() - 1 && charFreq.size() != set.size()) {
                i++;
                char ch = str.charAt(i);
                charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
            }

            while (j < i && charFreq.size() == set.size()) {
                if (i - j < ans) {
                    ans = i - j;
                }

                j++;
                char ch = str.charAt(j);
                if (charFreq.get(ch) == 1) {
                    charFreq.remove(ch);
                } else {
                    charFreq.put(ch, charFreq.get(ch) - 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "GEEKSGEEKSFOR";
        System.out.println(findSubString(str));
    }

}
