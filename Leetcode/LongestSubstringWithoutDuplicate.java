import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> vis = new HashMap<>();
        int ans = 0;
        int curLen = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(vis.containsKey(ch)) {
                curLen = Math.min(curLen+1, i-vis.get(ch));
                vis.put(ch, i);
            } else {
                curLen++;
                vis.put(ch, i);
            }

            ans = Math.max(ans, curLen);
        }

        return ans;
    }

}
