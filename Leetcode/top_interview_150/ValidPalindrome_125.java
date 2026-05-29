package top_interview_150;

/**
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidPalindrome_125 {

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        String loweredStr = s.toLowerCase();

        while (i < j) {
            if (isAlphaNumChar(loweredStr.charAt(i)) && isAlphaNumChar(loweredStr.charAt(j))) {
                if (loweredStr.charAt(i) != loweredStr.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                    continue;
                }
            }

            if (!isAlphaNumChar(loweredStr.charAt(i))) {
                i++;
            }
            if (!isAlphaNumChar(loweredStr.charAt(j))) {
                j--;
            }
        }

        return true;
    }

    private static boolean isAlphaChar(char ch) {
        int diff = ch - 'a';
        return diff >= 0 && diff < 26;
    }

    private static boolean isNumChar(char ch) {
        int diff = ch - '0';
        return diff >= 0 && diff < 10;
    }

    private static boolean isAlphaNumChar(char ch) {
        return isAlphaChar(ch) || isNumChar(ch);
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println(ValidPalindrome_125.isPalindrome(s));
        String s = "race a car";
        System.out.println(ValidPalindrome_125.isPalindrome(s));
    }

}
