import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class RabinCarp_73 {

    public static ArrayList<Integer> search(String pattern, String text) {
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

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "geek";
        System.out.println(search(pattern, text));
    }

}
