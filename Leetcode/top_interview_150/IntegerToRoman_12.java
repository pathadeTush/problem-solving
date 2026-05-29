package top_interview_150;

import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IntegerToRoman_12 {

    static Map<Integer, Character> mp = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L',
            100, 'C', 500, 'D', 1000, 'M');

    public static String intToRoman(int num) {
        int totalDigit = (int) Math.log10(num) + 1;
        int decimalPlace = (int) Math.pow(10, totalDigit - 1);
        StringBuffer ans = new StringBuffer();
        int currNum = num;
        int rem = 0;
        for (int i = 0; i < totalDigit; i++) {
            rem = currNum % decimalPlace;
            int decimalNum = currNum - rem;
            currNum = rem;
            ans.append(toRoman(decimalNum));
            decimalPlace /= 10;
        }

        return ans.toString();
    }

    private static String toRoman(int decimalNum) {
        if (decimalNum == 0) {
            return "";
        }
        if (mp.containsKey(decimalNum)) {
            return String.valueOf(mp.get(decimalNum));
        }

        String decimalNumStr = String.valueOf(decimalNum);
        int totalDigit = decimalNumStr.length();
        StringBuffer ans = new StringBuffer();
        if (decimalNumStr.charAt(0) == '4' || decimalNumStr.charAt(0) == '9') {
            int nextGreaterNum = decimalNum + (int) Math.pow(10, totalDigit - 1);
            int diff = nextGreaterNum - decimalNum;
            ans.append(mp.get(diff));
            ans.append(mp.get(nextGreaterNum));
        } else {
            if (decimalNumStr.charAt(0) < '4') {
                int previousGreaterNum = (int) Math.pow(10, totalDigit - 1);
                int count = decimalNum / previousGreaterNum;
                for (int i = 0; i < count; i++) {
                    ans.append(mp.get(previousGreaterNum));
                }
            } else {
                int previousGreaterNum = (int) Math.pow(10, totalDigit - 1);
                int count = decimalNumStr.charAt(0) - '5';
                ans.append(mp.get(5 * previousGreaterNum));
                for (int i = 0; i < count; i++) {
                    ans.append(mp.get(previousGreaterNum));
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
//        int num = 3749;
//        System.out.println(IntegerToRoman_12.intToRoman(num));
//        int num = 58;
//        System.out.println(IntegerToRoman_12.intToRoman(num));
        int num = 1994;
        System.out.println(IntegerToRoman_12.intToRoman(num));
    }

}
