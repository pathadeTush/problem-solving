/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j+i < n; j++) {
                if(isPalindrome(j, j+i, s)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(int i, int j, String s) {
        int l = i;
        int r = j;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(PalindromicSubstrings.countSubstrings("aaa"));
    }

}
