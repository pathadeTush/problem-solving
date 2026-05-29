package top_interview_150;

import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
 */
public class RomanToInteger_13 {

    static Map<Character, Integer> mp = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (i + 1 >= n || mp.get(ch) >= mp.get(s.charAt(i + 1))) {
                ans += mp.get(ch);
            } else {
                ans -= mp.get(ch);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        String s = "III";
//        System.out.println(RomanToInteger_13.romanToInt(s));
//        String s = "LVIII";
//        System.out.println(RomanToInteger_13.romanToInt(s));
        String s = "MCMXCIV";
        System.out.println(RomanToInteger_13.romanToInt(s));
    }

}
